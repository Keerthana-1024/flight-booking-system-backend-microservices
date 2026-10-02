package com.example.demo1.controller;

import com.example.demo1.dto.FlightCardDTO;
import com.example.demo1.dto.OfferRequestDTO;
import com.example.demo1.service.FlightService;
import com.example.demo1.dto.OfferRequestBody;
import com.example.demo1.service.OfferRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class FlightController {

    private final FlightService flightService;
    @Autowired
    OfferRequestService offerRequestServiceObj;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

//    @GetMapping("/flights")
//    public List<FlightCardDTO> getFlight() throws Exception {
//        return flightService.getAllFlights();
//    }
    @PostMapping("/postOfferRequests")
    public List<FlightCardDTO> postOfferRequests(@RequestBody OfferRequestBody obj) throws Exception {
        List<OfferRequestDTO> flightIds=offerRequestServiceObj.getOfferRequests(obj);
        String offerRequestId = flightIds.getFirst().getId();
        System.out.println(offerRequestId);

        return flightService.getAllFlights(offerRequestId);
    }
}