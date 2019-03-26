package my_spring;

import lombok.Data;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Data
public class Hobbit {
    @InjectRandomInt(min=30,max=100)
    private int power;
    @InjectRandomInt(min=12,max=20)
    private int speed;


}
