package my_spring;

import jdk.jfr.TransitionTo;

/**
 * @author Evgeny Borisov
 */

public class SafeChargeServiceImpl implements SafeChargeService {
    @Override
    @Benchmark
    public void doWork() {
        System.out.println("working");
    }

    @Override
    public void drinkBeer() {
        System.out.println("drinking in Thursday!!!");
    }
}
