package my_spring;

/**
 * @author Evgeny Borisov
 */
public interface ProxyConfigurator {
    Object wrapWithProxy(Object object, Class type);
}
