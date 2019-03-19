package io;

import lombok.SneakyThrows;

import java.io.*;

/**
 * @author Evgeny Borisov
 */
public class MainToRead {
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("c:\\tmp\\persons.obj123");


        var fileInputStream = new FileInputStream(file);
        var objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(o);



    }
}






