package my_spring;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
       ObjectFactory.getInstance().createObject(IRobot.class).cleanRoom();
    }
}
