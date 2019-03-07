package com.naya.polimorphism;

/**
 * @author Evgeny Borisov
 */
public class AnimalDoctor {
    public void treat(Animal animal) {
        for (int i = 0; i < 10; i++) {

        }
        animal.makeVoice();
        if (animal instanceof Dog) {

            Dog dog = (Dog) animal;
        }
    }
}
