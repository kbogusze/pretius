package com.pretius.currencyexchange.demo.ToolKit;

import com.pretius.currencyexchange.demo.models.CurrencyExchangeResult;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 *
 * @author Krzysztof Boguszewski
 */
public class CurrencyCalculatorTest {

    @Test
    public void calculatePLNtoPLN() {
        CurrencyExchangeResult calculate = CurrencyCalculator.calculate("PLN", 1.0, "PLN");
        assertThat(calculate.getAmount(), is(1.0));
    }

    @Test
    public void calculatePLNtoUSD() {
        CurrencyExchangeResult calculate = CurrencyCalculator.calculate("PLN", 1.0, "USD");
        assertThat(calculate.getCode(), is("USD"));

    }
}