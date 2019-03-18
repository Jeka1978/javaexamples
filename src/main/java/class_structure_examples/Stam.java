package class_structure_examples;

/**
 * @author Evgeny Borisov
 */
public class Stam {
    static {
        System.out.println("I'm static block");
    }

    {
        System.out.println("initializer");
    }


}
