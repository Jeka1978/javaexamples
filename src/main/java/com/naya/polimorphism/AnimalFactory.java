package com.naya.polimorphism;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class AnimalFactory {
    private Random random = new Random();
    private List<Supplier<Animal>> animalSuppliers = List.of(() -> new Dog(), Cat::new);


    Animal createRandomAnimal(){

        Supplier<Animal> animalSupplier = animalSuppliers.get(random.nextInt(animalSuppliers.size()));
        return animalSupplier.get();
    }
}
