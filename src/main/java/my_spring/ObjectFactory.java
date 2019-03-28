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
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();
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
        Set<Class<? extends ProxyConfigurator>> types = scanner.getSubTypesOf(ProxyConfigurator.class);
        for (Class<? extends ProxyConfigurator> type : types) {
            if (!Modifier.isAbstract(type.getModifiers())) {
                proxyConfigurators.add(type.getDeclaredConstructor().newInstance());
            }
        }

    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);

        T t = create(type);

        configure(t);

        handleInitMethods(type, t);

        t = wrapWithProxyIfNeed(type, t);

        return t;
    }

    private <T> T wrapWithProxyIfNeed(Class<T> type, T t) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = (T) proxyConfigurator.wrapWithProxy(t, type);
        }
        return t;
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
