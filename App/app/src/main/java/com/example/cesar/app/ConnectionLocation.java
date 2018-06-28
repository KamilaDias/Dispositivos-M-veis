package com.example.cesar.app;

/**
 * Created by cesar on 28/06/2018.
 */

public class ConnectionLocation {
    public Location getCepLocation(String cepStr) {
        Location LocationObj = null;
        try {
            ConnectionLatLng connection = new ConnectionLatLng();
            LocationObj = connection.sendGet(cepStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LocationObj;
    }
}
