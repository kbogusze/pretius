package com.pretius.currencyexchange.demo.cache;

import com.pretius.currencyexchange.demo.models.CurrencyRate;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 *
 * @author Krzysztof Boguszewski
 */
public class NBPCacheTest {

    @Test
    public void returnNoResultsWhenWrongCurrency() throws Exception {
        Optional<CurrencyRate> currency = NBPCache.findByCurrency("abc");
        assertThat(currency.isPresent(), is(false));
    }

    @Test
    public void returnResultByUSDCode() throws Exception {
        Optional<CurrencyRate> currency = NBPCache.findByCode("USD");
        assertThat(currency.isPresent(), is(true));
    }

    @Test
    public void returnResultByLowerCase() throws Exception {
        Optional<CurrencyRate> currency = NBPCache.findByCode("uSd");
        assertThat(currency.isPresent(), is(true));
    }

}