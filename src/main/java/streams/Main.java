package streams;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("abc", "java", "scala");
        var list2 = list.stream().filter(s -> !s.startsWith("a")).collect(Collectors.toList());
        list2.forEach(System.out::println);
        list2.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
