package java8;

/**
 * @author Evgeny Borisov
 */
public class MyService {
    public void doSomething(Worker worker) {
        System.out.println("I'm starting");
        worker.work();
        System.out.println("I'm finished");
    }
}
