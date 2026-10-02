package com.example.demo1.dto;

public class OfferRequestBody {
    private String origin;
    private String departure;
    private String departure_date;
    private int adults;
    private int children;

    public void set(String origin,String departure,String departure_date,int adults , int children){
        this.origin=origin;
        this.departure=departure;
        this.departure_date=departure_date;
        this.adults=adults;
        this.children=children;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChildren(int children) {
        this.children = children;
    }
}
