package com.example.demo1.service;

import com.example.demo1.client.DuffelClient;
import com.example.demo1.dto.FlightCardDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    DuffelClient duffelClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<FlightCardDTO> getAllFlights(String Id) throws Exception {

        String json = duffelClient.getOffers(Id);

        JsonNode root = objectMapper.readTree(json);

        JsonNode offers = root.get("data");

        List<FlightCardDTO> flights = new ArrayList<>();

        for (JsonNode offer : offers) {
            FlightCardDTO flight = objectMapper.treeToValue(
                    offer,
                    FlightCardDTO.class
            );

            flights.add(flight);
        }

        return flights;
    }
}