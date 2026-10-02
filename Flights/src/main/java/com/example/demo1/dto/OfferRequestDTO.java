package com.example.demo1.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferRequestDTO {
    @JsonProperty("client_key")
    private String client_key;

    @JsonProperty("id")
    private String id;

    public String getClient_key() {
        return client_key;
    }

    public String getId() {
        return id;
    }
}
