package com.example.demo1.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DuffelClient {
    @Value("${duffelApi}")
    String duffelApi;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getOffers(String offerReqId)  throws Exception {
//    String offerReqId = "orq_0000BAu5kdGOIQPm1Q0PuK";
        String url =
                "https://api.duffel.com/air/offers"
                        + "?offer_request_id=" + offerReqId
                        + "&limit=2";

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer "+duffelApi);
        headers.set("Duffel-Version", "v2");
//        headers.set("Accept-Encoding", "gzip");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response =null;
try {
    response =
            restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
            );
} catch (Exception e) {
    System.out.println("Exception : " + e.getMessage());
//    e.printStackTrace();
   throw new RuntimeException(e);
}
        return response.getBody();
    }
}