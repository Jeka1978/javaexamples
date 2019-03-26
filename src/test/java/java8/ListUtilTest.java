package java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
public class ListUtilTest {

    @Test
    public void countDuplicates() {
        List<String> strings = asList("Java", "java", "Java", "Scala", "groovy");
        int amount = ListUtil.countDuplicates(strings, "java", (t1, t2) -> t1.equalsIgnoreCase(t2));
        Assert.assertEquals(3,amount);
    }
}