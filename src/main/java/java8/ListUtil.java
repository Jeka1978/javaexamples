package java8;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class ListUtil {
    public static <T> int countDuplicates(List<T> list, T t /*todo add equalator*/) {
        int counter = 0;
        for (T t1 : list) {
            if (t1.equals(t)) {
                counter++;
            }
        }
        return counter;
    }
}
