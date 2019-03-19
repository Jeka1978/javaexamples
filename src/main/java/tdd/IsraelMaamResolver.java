package tdd;

import lombok.Getter;
import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */

public class IsraelMaamResolver implements MaamResolver {
    @Getter
    private double maam;

    @SneakyThrows
    public IsraelMaamResolver() {
        Thread.sleep(5000);
        maam = 0.18;
    }


}
