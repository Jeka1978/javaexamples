package java8;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Evgeny Borisov
 */
public class ListUtil {


    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        integers.forEach(System.out::println);



        forEachWithDelay(integers,2000,integer -> System.out.println(integer) );
    }


    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer<T> consumer) {


        for (T t : list) {
            consumer.accept(t);
            Thread.sleep(delay);
        }
    }




    public static <T> int countDuplicates(List<T> list, T t, Equalator<T> equalator ) {
        int counter = 0;
        for (T t1 : list) {
            if (equalator.equals(t,t1)) {
                counter++;
            }
        }
        return counter;
    }
}
