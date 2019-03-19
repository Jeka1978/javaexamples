package tdd;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
public class TaxCalc {


    private MaamResolver maamResolver;

    public double withMaam(double price) {
        return maamResolver.getMaam()*price +price;
    }


}
