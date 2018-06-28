package com.example.cesar.app;

import com.google.android.gms.maps.model.LatLng;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cesar on 05/03/2018.
 */

public class ConnectionLatLng {
    private final String USER_AGENT = "Mozilla/5.0";
    StringBuffer response;

    // HTTP GET request
    public Location sendGet(String cepStr) throws Exception {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + cepStr + "&key=AIzaSyB4Em_5JHnlLmT0AwLSA5Z-PEoMaXZP66A";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Location latLng = null;
        try {
            JSONObject jsonObject = new JSONObject(response.toString());

            double lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
                    .getJSONObject("geometry").getJSONObject("location")
                    .getDouble("lng");

            double lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
                    .getJSONObject("geometry").getJSONObject("location")
                    .getDouble("lat");
            latLng = new Location(lat, lng);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLng;
    }

    public CEP findItem(JSONObject obj) {
        CEP CEP = null;
        try {
            CEP = (new CEP(obj.getString("CEP"),
                    obj.getString("logradouro"),
                    obj.getString("complemento"),
                    obj.getString("bairro"),
                    obj.getString("localidade"),
                    obj.getString("uf"),
                    obj.getString("unidade"),
                    obj.getString("ibge"),
                    obj.getString("gia")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return CEP;
    }

    public StringBuffer retorna(String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        /*return (new CEP(("cep"),
                ("logradouro"),
                ("complemento"),
                ("bairro"),
                ("localidade"),
                ("uf"),
                ("unidade"),
                ("ibge"),
                ("gia")));*/
        return response;
    }
}