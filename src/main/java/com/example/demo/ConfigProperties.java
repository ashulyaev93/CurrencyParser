package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private String keyCurrency;
    private String currency;
    private String keyGif;
    private String tagRich;
    private String tagBroke;
    private String rating;
    private String random_id;
    private String dataConfig;

    public ConfigProperties(){
        Properties property = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            this.keyCurrency = property.getProperty("db.keyCurrency");
            this.currency = property.getProperty("db.currency");
            this.keyGif = property.getProperty("db.keyGif");
            this.tagRich = property.getProperty("db.tagRich");
            this.tagBroke = property.getProperty("db.tagBroke");
            this.rating = property.getProperty("db.rating");
            this.random_id = property.getProperty("db.random_id");
            this.dataConfig = property.getProperty("db.data_config");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public String getKeyCurrency() {
        return keyCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public String getKeyGif() {
        return keyGif;
    }

    public String getTagRich() {
        return tagRich;
    }

    public String getTagBroke() {
        return tagBroke;
    }

    public String getRating() {
        return rating;
    }

    public String getRandom_id() {
        return random_id;
    }

    public String getDataConfig() {
        return dataConfig;
    }
}
