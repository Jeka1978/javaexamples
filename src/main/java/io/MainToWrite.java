package io;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author Evgeny Borisov
 */
public class MainToWrite {
    @SneakyThrows
    public static void main(String[] args) {
        Human human = new Human("Jonathan", 31);
        File file = new File("c:\\tmp\\persons.obj123");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        var fileOutputStream = new FileOutputStream(file);
        var objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(human);



    }
}






