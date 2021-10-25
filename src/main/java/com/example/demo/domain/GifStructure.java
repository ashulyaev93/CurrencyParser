package com.example.demo.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})

public class GifStructure {
    @JsonProperty("data")
    private Map<String, Object> data = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getData(){
        return this.data;
    }

    @JsonAnySetter
    public void setData(String name, Object value) {
        this.data.put(name, value);
    }
}
