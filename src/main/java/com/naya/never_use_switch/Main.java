package com.naya.never_use_switch;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executors;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        Integer integer = new Integer(12);

        MessageSenderImpl sender = new MessageSenderImpl();
        DataFactory dataFactory = new DataFactory();
        Random random = new Random();

        while (true) {
            Message message = Message.builder().distributionType(random.nextInt(3) + 1).build();
            try {
                sender.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(500);
        }
    }
}
