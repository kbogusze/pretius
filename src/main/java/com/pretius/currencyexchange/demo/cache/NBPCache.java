/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pretius.currencyexchange.demo.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pretius.currencyexchange.demo.models.CurrencyRate;
import com.pretius.currencyexchange.demo.models.IncomingRates;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Krzysztof Boguszewski
 */
public class NBPCache {
 
    private static NBPCache instance;
    private IncomingRates tableA;

    public NBPCache() {
        this.tableA = new IncomingRates();
    }

    private static NBPCache getInstance() {
      if(instance == null) {
         instance = new NBPCache();
         initCache(instance);
      }
      return instance;
    }
    
    private static synchronized void initCache (NBPCache instance){
        try {
            RestTemplate restTemplate = new RestTemplate();
            String uri = "http://api.nbp.pl/api/exchangerates/tables/a?format=json";
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null,String.class);
            ObjectMapper mapper = new ObjectMapper();
            List<IncomingRates> list = mapper.readValue(response.getBody(), TypeFactory.defaultInstance().constructCollectionLikeType(List.class, IncomingRates.class));
            if (list.size() > 0)
                instance.setTableA(list.get(0));
        } catch (IOException ex) {
            Logger.getLogger(NBPCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setTableA(IncomingRates tableA) {
        this.tableA = tableA;
    }
        
    public static synchronized Optional<CurrencyRate> findByCurrency(String currency) {
        return getInstance().tableA.getRates().stream().filter(p ->p.getCurrency()!=null && p.getCurrency().toUpperCase().equals(currency.toUpperCase())).findAny();
    }

    public static synchronized Optional<CurrencyRate> findByCode(String code) {
        return getInstance().tableA.getRates().stream().filter(p ->p.getCode()!=null && p.getCode().toUpperCase().equals(code.toUpperCase())).findAny();
    }
}
