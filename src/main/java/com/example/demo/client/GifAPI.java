package com.example.demo.client;

import com.example.demo.domain.GifStructure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gifClient",url = "api.giphy.com/v1/gifs/random")
public interface GifAPI {

    @RequestMapping(method = RequestMethod.GET)
    GifStructure apiData(@RequestParam(value="api_key") String key,
                         @RequestParam(value="tag") String tag,
                         @RequestParam(value="rating") String rating,
                         @RequestParam(value="random_id") String random_id);
}
