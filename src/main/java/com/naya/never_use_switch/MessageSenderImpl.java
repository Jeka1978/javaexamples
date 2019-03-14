package com.naya.never_use_switch;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */

public class MessageSenderImpl implements MessageSender {

    private Map<Integer, Distributor> map = new HashMap<>();

    @SneakyThrows
    public MessageSenderImpl() {
        Reflections scanner = new Reflections("com.naya.never_use_switch");
        Set<Class<? extends Distributor>> classes = scanner.getSubTypesOf(Distributor.class);

        for (Class<? extends Distributor> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                Distributor distributor = aClass.newInstance();
                int code = distributor.getMyCode();
                if (map.containsKey(code)) {
                    throw new IllegalStateException(code + " already in use");
                }
                map.put(code, distributor);
            }
        }

    }

    @Override
    public void send(Message message) {
        int type = message.getDistributionType();
        Distributor distributor = map.get(type);
        if (distributor == null) {
            throw new IllegalStateException(type + " is not supported yet");
        }
        distributor.distribute(message);

    }
}
