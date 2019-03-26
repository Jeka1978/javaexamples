package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Reflections scanner = new Reflections("my_spring");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurators.add(aClass.getDeclaredConstructor().newInstance());
            }
        }

    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);

        T t = create(type);

        configure(t);

        handleInitMethods(type, t);

        if (type.isAnnotationPresent(Benchmark.class)) {

            if (type.getInterfaces().length == 0) {
                return (T) Enhancer.create(type, new org.springframework.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return invokationHandlerMethod(method, args, (T) t);
                    }
                });
            }

            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return invokationHandlerMethod(method, args, t);
                }
            });
        }

        return t;
    }

    private <T> Object invokationHandlerMethod(Method method, Object[] args, T t) throws IllegalAccessException, InvocationTargetException {
        System.out.println("******** BENCHMARK started for method " + method.getName() + " ********");
        long start = System.nanoTime();
        Object retVal = method.invoke(t, args);
        long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println("******** BENCHMARK ended for method " + method.getName() + " ********");
        return retVal;
    }

    private <T> void handleInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configurator->configurator.configure(t));
    }

    private <T> T create(Class<T> type) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return type.getDeclaredConstructor().newInstance();
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }
        return type;
    }


}
