package com.example.demo.client;

import com.example.demo.domain.CurrencyStructure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "apiClient",url = "https://openexchangerates.org/api/latest.json")
public interface CurrencyAPI {

    @RequestMapping(method = RequestMethod.GET)
    CurrencyStructure currencyData(@RequestParam(value="app_id") String key);
}