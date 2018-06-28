package com.example.cesar.app;

/**
 * Created by cesar on 05/03/2018.
 */

public class ConnectionCEP {
    public CEP getCepConnection(String cepStr) {
        CEP CEPObj = null;
        try {
            ConnectionAdress connectionAdress = new ConnectionAdress();
            CEPObj = connectionAdress.sendGet(cepStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CEPObj;
    }
}