package com.naya.never_use_switch;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        MessageSenderImpl sender = new MessageSenderImpl();
        DataFactory dataFactory = new DataFactory();
        Random random = new Random();

        while (true) {
            Message message = Message.builder().distributionType(random.nextInt(2) + 1).build();
            sender.send(message);
            Thread.sleep(500);
        }
    }
}
