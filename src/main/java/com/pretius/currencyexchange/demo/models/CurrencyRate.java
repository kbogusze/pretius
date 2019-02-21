/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pretius.currencyexchange.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Krzysztof Boguszewski
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRate {
    String currency;
    String code;
    Double mid;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }
    
    
}
