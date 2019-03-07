package com.naya;

import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Evgeny Borisov
 */
public class Main {


    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {


        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.forEach(System.out::println);

        String str = "java";
        str = str.toUpperCase();


        LocalDate now = LocalDate.now();
        now = now.withYear(1980).minusDays(1).withDayOfMonth(3);

        Employee employee = Employee.builder().salary(400000).beer("Tuborg", 3).beer("Leff", 7).age(18).bonus(20).name("Irena").build();
        System.out.println("employee = " + employee);
        System.out.println();
        boolean b = false;


    }
}
