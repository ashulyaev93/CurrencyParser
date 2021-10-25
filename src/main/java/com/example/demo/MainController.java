package com.example.demo;

import com.example.demo.client.CurrencyAPI;
import com.example.demo.client.GifAPI;
import com.example.demo.domain.GifStructure;
import com.example.demo.domain.CurrencyStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController{

    private CurrencyAPI currencyAPI;
    private GifAPI gifAPI;
    private float rubPrevious;
    private float rubCurrent;
    private ConfigProperties configProperties;

    @Autowired
    public MainController(CurrencyAPI currencyAPI,
                          GifAPI gifAPI){
        this.currencyAPI = currencyAPI;
        this.gifAPI = gifAPI;
        this.configProperties = new ConfigProperties();
    }

    @RequestMapping(value = "/currency")
    public Object currency(){

        this.rubPrevious = this.rubCurrent;

        CurrencyStructure currencyStructure = currencyAPI.currencyData(configProperties.getKeyCurrency());
        Map<String,Float> rates = currencyStructure.getRates();
        rubCurrent = rates.get(configProperties.getCurrency());

        GifStructure gifStructureRich = gifAPI.apiData(configProperties.getKeyGif(), configProperties.getTagRich(), configProperties.getRating(), configProperties.getRandom_id());
        GifStructure gifStructureBroke = gifAPI.apiData(configProperties.getKeyGif(), configProperties.getTagBroke(), configProperties.getRating(), configProperties.getRandom_id());
        Map<String, Object> dataRich = gifStructureRich.getData();
        Map<String, Object> dataBroke = gifStructureBroke.getData();
        Object embedUrlRich = dataRich.get(configProperties.getDataConfig());
        Object embedUrlBroke = dataBroke.get(configProperties.getDataConfig());

        String href = (String) (rubPrevious < rubCurrent ? embedUrlRich : embedUrlBroke);
        String img = "<iframe src=\""+ href +"\" width=\"300\" height=\"300\"></iframe>";

        ResponseEntity re = new ResponseEntity(img, HttpStatus.OK);
        System.out.println(rubPrevious + " " + rubCurrent);

        return re;
    }
}
