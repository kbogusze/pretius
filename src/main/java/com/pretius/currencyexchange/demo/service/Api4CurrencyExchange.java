package com.pretius.currencyexchange.demo.service;

import com.pretius.currencyexchange.demo.ToolKit.CurrencyCalculator;
import com.pretius.currencyexchange.demo.models.CurrencyExchangeResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 *
 * @author Krzysztof Boguszewski
 */
@RestController
public class Api4CurrencyExchange {

    @RequestMapping(value = "/api/currencyrates/{currency}/{amount}/{finalcurrency}", method = RequestMethod.GET, produces="application/json")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyExchangeResult getCurrencyRate(@PathVariable("currency") String currency, @PathVariable("amount") String amount, @PathVariable("finalcurrency") String finalcurrency)
    {
        return CurrencyCalculator.calculate(currency,  Double.valueOf(amount), finalcurrency);
    }

}
