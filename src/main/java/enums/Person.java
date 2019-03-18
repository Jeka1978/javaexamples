package enums;

import lombok.Builder;
import lombok.Data;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
public class Person {
    private String name;
    private Gender gender;

    public static void main(String[] args) {
        Person person = Person.builder().name("Vasya").gender(Gender.MALE).build();
        String hebrewDesc = person.getGender().getHebrewDesc();
        System.out.println("hebrewDesc = " + hebrewDesc);
        person.getGender().printDbCode();

        int x = 2;
        System.out.println(Gender.findByDbCode(x).getHebrewDesc());




    }
}
