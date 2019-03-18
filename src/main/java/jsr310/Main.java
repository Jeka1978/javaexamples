package jsr310;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate yesterday = now.minusDays(1);
        System.out.println(yesterday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        System.out.println(yesterday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRENCH));
        System.out.println(yesterday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.JAPAN));
        System.out.println(yesterday.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.JAPAN));


        LocalDate localDate = yesterday.withYear(1980);

        LocalDate jeka = LocalDate.of(1980, 10, 3);
        LocalDate jonathan = LocalDate.of(1987, 8, 18);
        System.out.println(ChronoUnit.DAYS.between(jeka, jonathan));



    }
}
