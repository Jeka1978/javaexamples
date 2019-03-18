package java8;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {

        MyService myService = new MyService();
        myService.doSomething(() -> System.out.println("worked!!!"));
    }
}
