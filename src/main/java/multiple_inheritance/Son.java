package multiple_inheritance;

/**
 * @author Evgeny Borisov
 */
public class Son implements Mother,Father {
    @Override
    public void talkToChildren() {
        Mother.super.talkToChildren();
        Father.super.talkToChildren();
    }

    public static void main(String[] args) {
        new Son().talkToChildren();
    }
}
