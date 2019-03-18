package com.naya.tdd;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Evgeny Borisov
 */
public class TestRunner {
    @SneakyThrows
    public void runAllTests(Object o) {
        Class<?> type = o.getClass();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("test")) {
                method.invoke(o);
            }
            if (method.isAnnotationPresent(SafeChargeTest.class)) {
                System.out.println("Specisal test is running...");
                method.invoke(o);
            }
        }

    }
}
