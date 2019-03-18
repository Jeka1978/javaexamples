package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
@Getter
public enum Gender {

    MALE(1,"גבר"), FEMALE(2,"אישה");

    {
        System.out.println("was created");
    }


    private final int dbCode;
    private final String hebrewDesc;

    public void printDbCode() {
        System.out.println(dbCode);
    }


    public static Gender findByDbCode(int dbCode) {

//       return Arrays.stream(values()).filter(gender -> gender.dbCode == dbCode).findAny().get();
        Gender[] genders = values();
        for (Gender gender : genders) {
            if (gender.dbCode == dbCode) {
                return gender;
            }
        }
        throw new RuntimeException(dbCode + " not found");
    }

}










