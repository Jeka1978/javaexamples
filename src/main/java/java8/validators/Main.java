package java8.validators;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        List<Validator> validators = List.of(new Validator1(), new Validator2(), new Validator333());
        validators.forEach(Validator::validate);
    }
}
