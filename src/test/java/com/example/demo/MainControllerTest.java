package com.example.demo;

import com.example.demo.client.CurrencyAPI;

import com.example.demo.client.GifAPI;
import com.example.demo.domain.CurrencyStructure;
import com.example.demo.domain.GifStructure;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.*;


import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = MainController.class)
public class MainControllerTest {
    CurrencyAPI currencyAPI;
    GifAPI gifAPI;

    @BeforeMethod
    void before(){
        this.currencyAPI = mock(CurrencyAPI.class);
        this.gifAPI = mock(GifAPI.class);
    }

    @Test
    public void testCurrency(){
        //given
        MainController mainControllerTest = new MainController(
                currencyAPI,
                gifAPI
        );

        CurrencyStructure currencyStructureTest = mock(CurrencyStructure.class);
        GifStructure gifStructureRichTest = mock(GifStructure.class);
        GifStructure gifStructureBrokeTest = mock(GifStructure.class);

        String keyCurrency = "47b10987e4bb45acbcc8995752f5cace";
        String keyGif = "cMjrWtq7iU1mqpYM6ejjZVaBUkVutuOR";
        String tagRich = "rich";
        String tagBroke = "broke";
        String rating = "g";
        String random_id = "e826c9fc5c929e0d6c6d423841a282aa";
        String base = "base";
        String disclaimer = "disclaimer";
        String license = "license";
        Long timestamp = 1L;

        Map<String,Float> ratesTest = new HashMap<>();
        ratesTest.put("RUB", 70.25F);

        Map<String,Object> dataRichTest = new HashMap<>();
        dataRichTest.put("embed_url","https:\\/\\/giphy.com\\/embed\\/qw7j9oHhS0wWguOhTK");
        Map<String,Object> dataBrokeTest = new HashMap<>();
        dataBrokeTest.put("embed_url","https:\\/\\/giphy.com\\/embed\\/BM10Y3Qq3EwK3z8yQd");

        //when
        when(currencyAPI.currencyData(keyCurrency)).thenReturn(currencyStructureTest);
        when(currencyStructureTest.getRates()).thenReturn(ratesTest);
        when(currencyStructureTest.getBase()).thenReturn(base);
        when(currencyStructureTest.getDisclaimer()).thenReturn(disclaimer);
        when(currencyStructureTest.getLicense()).thenReturn(license);
        when(currencyStructureTest.getTimestamp()).thenReturn(timestamp);

        when(gifAPI.apiData(keyGif,tagRich,rating,random_id)).thenReturn(gifStructureRichTest);
        when(gifAPI.apiData(keyGif,tagBroke,rating,random_id)).thenReturn(gifStructureBrokeTest);
        when(gifStructureRichTest.getData()).thenReturn(dataRichTest);
        when(gifStructureBrokeTest.getData()).thenReturn(dataBrokeTest);

        //then
        mainControllerTest.currency();
    }
}
