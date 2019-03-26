package tdd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class TaxCalcTest {

    @Test
    public void withMaam() {


        MaamResolver maamResolverMock = Mockito.mock(MaamResolver.class);
        Mockito.when(maamResolverMock.getMaam()).thenReturn(0.18);
        System.out.println(maamResolverMock.getMaam());

        TaxCalc taxCalc = new TaxCalc(maamResolverMock);
        double withMaam = taxCalc.withMaam(100);
        Assert.assertEquals(118,withMaam,0.000001);
    }
}