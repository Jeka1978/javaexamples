package com.naya;

import lombok.*;
import lombok.experimental.Wither;

import java.util.Map;
import java.util.Objects;

/**
 * @author Evgeny Borisov
 */


@Builder
@Wither
@Value
public class Employee {
    private String name;
    private int age;
    @NonNull
    private Integer salary;
    private int bonus;
    @Singular
    private Map<String,Integer> beers;

}
