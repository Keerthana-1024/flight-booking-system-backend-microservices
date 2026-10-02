package com.example.demo1.service;

import com.example.demo1.client.OfferRequest;
import com.example.demo1.dto.OfferRequestDTO;
import com.example.demo1.dto.OfferRequestBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OfferRequestService {
    @Autowired
    OfferRequest offerReqObj;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public List<OfferRequestDTO> getOfferRequests(OfferRequestBody obj) throws JsonProcessingException {
        String json = offerReqObj.createOfferRequest(obj);

        JsonNode root = objectMapper.readTree(json);

        JsonNode offers = root.get("data");

//        List<OfferRequestDTO> flights = new ArrayList<>();
//
//        for (JsonNode offer : offers) {
//            OfferRequestDTO flight = objectMapper.treeToValue(
//                    offer,
//                    OfferRequestDTO.class
//            );
//
//            flights.add(flight);
//        }
//
//        return flights;
        OfferRequestDTO offerRequest =
                objectMapper.treeToValue(offers, OfferRequestDTO.class);

        // Put the single DTO into a list
        List<OfferRequestDTO> result = new ArrayList<>();
        result.add(offerRequest);

        return result;
    }


}
