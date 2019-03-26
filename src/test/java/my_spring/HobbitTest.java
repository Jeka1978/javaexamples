package my_spring;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class HobbitTest {
    @Test
    public void testThatObjectFactoryInjectFieldsAccordingToInjectRandomIntAnnotation() {
        Hobbit hobbit = ObjectFactory.getInstance().createObject(Hobbit.class);
        Assert.assertNotEquals(0,hobbit.getPower());
        Assert.assertNotEquals(0,hobbit.getSpeed());
        System.out.println("hobbit = " + hobbit);
    }
}