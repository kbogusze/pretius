package com.pretius.currencyexchange.demo.models;

/**
 *
 * @author Krzysztof Boguszewski
 */
public class CurrencyExchangeResult {
    String code;
    Double amount;

    public CurrencyExchangeResult(String finalcurrency) {
        this.code = finalcurrency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
