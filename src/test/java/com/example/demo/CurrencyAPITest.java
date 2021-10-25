package com.example.demo;

import com.example.demo.client.CurrencyAPI;
import com.example.demo.domain.CurrencyStructure;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CurrencyAPI.class)
public class CurrencyAPITest {

    @Test
    void testCurrencyAPI(){
        //given
        CurrencyAPI currencyAPITest = new CurrencyAPI() {
            @Override
            public CurrencyStructure currencyData(String key) {
                return null;
            }
        };

        String key = "key";

        //then
        currencyAPITest.currencyData(key);
    }
}
