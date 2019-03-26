package streams;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class PopularWordsService {
    @SneakyThrows
    public static void countWords(String fileName) {

        Stream<String> lines = Files.lines(Paths.get(fileName));
        Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split("\\W+")));
        Map<String, Long> map = words.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        map.entrySet().stream().sorted((o1, o2) -> (int) (o2.getValue()-o1.getValue())).forEach(System.out::println);


    }

    public static void main(String[] args) {
        countWords("data/song.txt");
    }
}
