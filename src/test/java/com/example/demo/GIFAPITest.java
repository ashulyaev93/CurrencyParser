package com.example.demo;

import com.example.demo.client.GifAPI;
import com.example.demo.domain.GifStructure;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GifAPI.class)
public class GIFAPITest {

    @Test
    void testGifAPI(){
        //given
        GifAPI gifAPITest = new GifAPI() {
            @Override
            public GifStructure apiData(String key, String tag, String rating, String random_id) {
                return null;
            }
        };

        String key = "key";
        String tag = "tag";
        String rating = "rating";
        String random_id = "random_id";

        //then
        gifAPITest.apiData(key,tag,rating,random_id);
    }
}
