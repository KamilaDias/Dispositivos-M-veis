package com.example.cesar.app;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cesar on 05/03/2018.
 */

public class ConnectionAdress {
    private final String USER_AGENT = "Mozilla/5.0";
    StringBuffer response;

    // HTTP GET request
    public CEP sendGet(String cepStr) throws Exception {
        String url = "https://viacep.com.br/ws/" + cepStr + "/json/";

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

        //System.out.println(response.toString());

        //CEP CEP = findItem(new JSONObject(response.toString()));

        CEP CEP = null;
        try {
            JSONObject cepObj = new JSONObject(response.toString());
            CEP = (new CEP(cepObj.getString("CEP"),
                    cepObj.getString("logradouro"),
                    cepObj.getString("complemento"),
                    cepObj.getString("bairro"),
                    cepObj.getString("localidade"),
                    cepObj.getString("uf"),
                    cepObj.getString("unidade"),
                    cepObj.getString("ibge"),
                    cepObj.getString("gia")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CEP;
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