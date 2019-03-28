package tdd;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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
