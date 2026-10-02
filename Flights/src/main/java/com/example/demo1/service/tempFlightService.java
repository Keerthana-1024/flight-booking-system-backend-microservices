//package com.example.demo.service;
//
//import com.example.demo.client.DuffelClient;
//import com.example.demo.dto.tempFlightCardDTO;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class tempFlightService {
//
//    @Autowired
//    DuffelClient duffelClient;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    public tempFlightCardDTO getFirstFlight() throws Exception {
//
//        // Get JSON from Duffel
//        String json = duffelClient.getOffers();
//
//        // Convert JSON string into a tree
//        JsonNode root = objectMapper.readTree(json);
//
//        // Get first flight offer
//        JsonNode firstOffer = root.get("data").get(0);
//
//        // Get airline name
//        String airline = firstOffer
//                .get("owner")
//                .get("name")
//                .asText();
//
//        // Get price
//        String price = firstOffer
//                .get("total_amount")
//                .asText();
//
//        return new tempFlightCardDTO(airline, price);
//    }
//}
///*
//package com.example.demo.service;
//
//import com.example.demo.client.DuffelClient;
//import com.example.demo.dto.FlightCardDTO;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FlightService {
//
//    @Autowired
//    DuffelClient duffelClient;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    public FlightCardDTO getFirstFlight() throws Exception {
//
//        String json = duffelClient.getOffers();
//
//        JsonNode root = objectMapper.readTree(json);
//
//        JsonNode firstOffer = root.get("data").get(0);
//
//        FlightCardDTO dto = objectMapper.treeToValue(
//                firstOffer,
//                FlightCardDTO.class
//        );
//
//        return dto;
//    }
//}
// */