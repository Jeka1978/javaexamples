package inner_classes;

import java.util.Comparator;

/**
 * @author Evgeny Borisov
 */
public class StringByLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
