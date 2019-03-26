package my_spring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class JavaConfig implements Config {

    private Map<Class, Class> interface2ImplClass = new HashMap<>();

    public JavaConfig() {
        interface2ImplClass.put(Speaker.class, ConsoleSpeaker.class);
        interface2ImplClass.put(Cleaner.class, CleanerImpl.class);
    }

    @Override
    public <T> Class<T> getImplClass(Class<T> type) {
        return interface2ImplClass.get(type);
    }
}



