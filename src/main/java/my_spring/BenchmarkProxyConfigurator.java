package my_spring;

import lombok.SneakyThrows;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object wrapWithProxy(Object t, Class type) {

        if (type.isAnnotationPresent(Benchmark.class)|| Arrays.stream(type.getMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class))) {

            if (type.getInterfaces().length == 0) {
                return  Enhancer.create(type, new org.springframework.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return invokationHandlerMethod(method, args, t,type);
                    }
                });
            }

            return  Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return invokationHandlerMethod(method, args, t,type);
                }
            });
        }
        return t;
    }


    @SneakyThrows
    private <T> Object invokationHandlerMethod(Method method, Object[] args, T t, Class type) throws IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classMethod.isAnnotationPresent(Benchmark.class)||type.isAnnotationPresent(Benchmark.class)) {
            System.out.println("******** BENCHMARK started for method " + method.getName() + " ********");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println(end - start);
            System.out.println("******** BENCHMARK ended for method " + method.getName() + " ********");
            return retVal;
        }else {
            return method.invoke(t, args);
        }
    }
}
