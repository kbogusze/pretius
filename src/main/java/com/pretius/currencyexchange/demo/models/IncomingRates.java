/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pretius.currencyexchange.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Krzysztof Boguszewski
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingRates {
    String table;
    String no;
    String effectiveDate;
    List<CurrencyRate> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<CurrencyRate> getRates() {
        return rates;
    }

    public void setRates(List<CurrencyRate> rates) {
        this.rates = rates;
    }
    
    
}
