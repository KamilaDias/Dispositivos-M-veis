package com.example.cesar.app;

import android.app.Application;
import java.util.ArrayList;

/**
 * Created by cesar on 27/06/2018.
 */

public class ListaCEP extends Application {
    private static ListaCEP mInstance= null;
    protected ListaCEP(){}

    private ArrayList<CEP> lista = new ArrayList();

    public ArrayList<CEP> getLista() {
        return lista;
    }

    public void setLista(ArrayList<CEP> lista) {
        this.lista = lista;
    }
    public static synchronized ListaCEP getInstance() {
        if(null == mInstance){
            mInstance = new ListaCEP();
        }
        return mInstance;
    }
}