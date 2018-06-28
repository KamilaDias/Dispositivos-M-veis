package com.example.cesar.app;

/**
 * Created by cesar on 27/06/2018.
 */

public class Location {
    private Double Lat;
    private Double Lng;

    public Location(Double lat, Double lng) {
        Lat = lat;
        Lng = lng;
    }

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    public Double getLng() {
        return Lng;
    }

    public void setLng(Double lng) {
        Lng = lng;
    }
}