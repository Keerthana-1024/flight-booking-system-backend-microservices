package com.example.demo1.client;

import com.example.demo1.dto.OfferRequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OfferRequest {

    @Value("${duffelApi}")
    private String duffelApi;

    private final RestTemplate restTemplate = new RestTemplate();
    public String createOfferRequest(OfferRequestBody reqBody) {

        String url = "https://api.duffel.com/air/offer_requests";
        StringBuilder passengers = new StringBuilder();

        for (int i = 0; i < reqBody.getAdults(); i++) {
            passengers.append("""
            {
              "type": "adult"
            }""");

            if (i < reqBody.getAdults() - 1 || reqBody.getChildren() > 0) {
                passengers.append(",");
            }
        }

        for (int i = 0; i < reqBody.getChildren(); i++) {
            passengers.append("""
            {
              "type": "child"
            }""");

            if (i < reqBody.getChildren() - 1) {
                passengers.append(",");
            }
        }

        String requestBody = String.format("""
                {
                  "data": {
                    "cabin_class": "economy",
                    "slices": [
                      {
                        "departure_date": "%s",
                        "destination": "%s",
                        "origin": "%s"
                      }
                    ],
                    "passengers": [
                      %s
                    ]
                  }
                }
                """,reqBody.getDeparture_date(),reqBody.getDeparture(),reqBody.getOrigin(),passengers);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//        headers.set("Accept-Encoding", "gzip");
        headers.set("Duffel-Version", "v2");
        headers.setBearerAuth(duffelApi);

        HttpEntity<String> entity =
                new HttpEntity<>(requestBody, headers);

        try {

            ResponseEntity<String> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.POST,
                            entity,
                            String.class
                    );

            return response.getBody();

        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}