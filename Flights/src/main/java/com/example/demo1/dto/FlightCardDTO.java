package com.example.demo1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;
// consider a passengerDTO to send selective data to frontend later
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"id", "airline", "total_amount", "departureDate","departureTime","arrivalDate","arrivalTime","passengers"})
public class FlightCardDTO {

    @JsonProperty(value = "owner", access = JsonProperty.Access.WRITE_ONLY)
    private Owner owner;

    @JsonProperty("total_amount")
    private String price;

    @JsonProperty("id")
    private String flightId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Slices> slices;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getAirline() {
        return owner != null ? owner.getName() : null;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Slices> getSlices() {
        return slices;
    }

    public void setSlices(List<Slices> slices) {
        this.slices = slices;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Owner {

        private String name;

        public Owner() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Slices {

        private List<Segment> segments;

        public List<Segment> getSegments() {
            return segments;
        }

        public void setSegments(List<Segment> segments) {
            this.segments = segments;
        }
    }
    private List<Segment> firstSliceSegments() {
        if (slices == null || slices.isEmpty()) {
            return null;
        }
        List<Segment> segments = slices.get(0).getSegments();
        return (segments == null || segments.isEmpty()) ? null : segments;
    }

    public String getDepartureDate() {
        List<Segment> segments = firstSliceSegments();
        if (segments == null || segments.get(0).getDepartureDateTime() == null) {
            return null;
        }
        return segments.get(0).getDepartureDateTime().substring(0, 10);
    }

    public String getDepartureTime() {
        List<Segment> segments = firstSliceSegments();
        if (segments == null || segments.get(0).getDepartureDateTime() == null) {
            return null;
        }
        return segments.get(0).getDepartureDateTime().substring(11);
    }

    public String getArrivalDate() {
        List<Segment> segments = firstSliceSegments();
        if (segments == null || segments.get(segments.size() - 1).getArrivalDateTime() == null) {
            return null;
        }
        return segments.get(segments.size() - 1).getArrivalDateTime().substring(0, 10);
    }

    public String getArrivalTime() {
        List<Segment> segments = firstSliceSegments();
        if (segments == null || segments.get(segments.size() - 1).getArrivalDateTime() == null) {
            return null;
        }
        return segments.get(segments.size() - 1).getArrivalDateTime().substring(11);
    }

    public List<Map<String, Object>> getPassengers() {
        List<Segment> segments = firstSliceSegments();
        return segments == null ? null : segments.get(0).getPassengers();
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Segment {

        @JsonProperty("departing_at")
        private String departureDateTime;

        @JsonProperty("arriving_at")
        private String arrivalDateTime;

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private List<Map<String, Object>> passengers;

        public String getDepartureDateTime() {
            return departureDateTime;
        }

        public void setDepartureDateTime(String departureDateTime) {
            this.departureDateTime = departureDateTime;
        }

        public String getArrivalDateTime() {
            return arrivalDateTime;
        }

        public void setArrivalDateTime(String arrivalDateTime) {
            this.arrivalDateTime = arrivalDateTime;
        }

        public List<Map<String, Object>> getPassengers() {
            return passengers;
        }

        public void setPassengers(List<Map<String, Object>> passengers) {
            this.passengers = passengers;
        }
    }
}