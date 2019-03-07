package com.naya.polimorphism;

/**
 * @author Evgeny Borisov
 */
public class Dog implements Animal {

    public void bringStick() {
        System.out.println("take your stick");
    }

    @Override
    public void makeVoice() {
        System.out.println("au au");
    }
}
