package com.pretius.currencyexchange.demo.ToolKit;

import com.pretius.currencyexchange.demo.cache.NBPCache;
import com.pretius.currencyexchange.demo.models.CurrencyExchangeResult;
import com.pretius.currencyexchange.demo.models.CurrencyRate;

import java.util.Optional;

/**
 *
 * @author Krzysztof Boguszewski
 */
public class CurrencyCalculator {

    public static CurrencyExchangeResult calculate(String currency, double amount,String finalcurrency)
    {
        double mid = 1.0;
        double finalmid = 1.0;
        CurrencyExchangeResult result = new CurrencyExchangeResult(finalcurrency);

        if (currency.equals("PLN"))
            mid = 1.0;
        else {
            Optional<CurrencyRate> rate = NBPCache.findByCode(currency);
            if (rate.isPresent())
                mid = rate.get().getMid();
        }

        if (finalcurrency.equals("PLN"))
            finalmid = 1.0;
        else {
            Optional<CurrencyRate> rate = NBPCache.findByCode(finalcurrency);
            if (rate.isPresent()) {
                finalmid = rate.get().getMid();
            }
        }
        result.setAmount(mid/finalmid * amount);
        return result;
    }
}
