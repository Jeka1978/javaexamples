package com.naya.tdd;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
        MyTest myTest = new MyTest();
        testRunner.runAllTests(myTest);
    }
}
