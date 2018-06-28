package com.example.cesar.app;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //myView = inflater.inflate(R.layout.activity_maps, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView txt1 = getView().findViewById(R.id.textView);
        TextView txt2 = getView().findViewById(R.id.textView2);
        TextView txt3 = getView().findViewById(R.id.textView3);
        TextView txt4 = getView().findViewById(R.id.textView4);
        TextView txt5 = getView().findViewById(R.id.textView5);
        TextView txt6 = getView().findViewById(R.id.textView6);
        TextView txt7 = getView().findViewById(R.id.textView7);
        TextView txt8 = getView().findViewById(R.id.textView8);
        TextView txt9 = getView().findViewById(R.id.textView9);
        txt1.setText("CEP: ");
        txt2.setText("Logradouro: ");
        txt3.setText("Complemento: ");
        txt4.setText("Bairro: ");
        txt5.setText("Localidade: ");
        txt6.setText("Uf: ");
        txt7.setText("Unidade: ");
        txt8.setText("Ibge: ");
        txt9.setText("Gia: ");

        Button button = (Button) getView().findViewById(R.id.btnBuscar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                EditText cep = getView().findViewById(R.id.txtCep);
                //ConnectionCEP ConnectionCEP = new ConnectionCEP();
                //CEP CEPObj = ConnectionCEP.getCepConnection(cep.getText().toString());

                TextView txt1 = getView().findViewById(R.id.textView);
                TextView txt2 = getView().findViewById(R.id.textView2);
                TextView txt3 = getView().findViewById(R.id.textView3);
                TextView txt4 = getView().findViewById(R.id.textView4);
                TextView txt5 = getView().findViewById(R.id.textView5);
                TextView txt6 = getView().findViewById(R.id.textView6);
                TextView txt7 = getView().findViewById(R.id.textView7);
                TextView txt8 = getView().findViewById(R.id.textView8);
                TextView txt9 = getView().findViewById(R.id.textView9);
                /*
                ConnectionAdress connectionAdress = new ConnectionAdress();
                CEP CEPObj = null;
                try {
                    CEPObj = connectionAdress.sendGet(cep.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                */
                ConnectionAdress connectionAdress = new ConnectionAdress();
                try {
                    txt1.setText(connectionAdress.retorna(cep.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    StringBuffer response = connectionAdress.retorna(cep.getText().toString());
                    JSONObject obj = new JSONObject(response.toString());
                    CEP found = (new CEP(obj.getString("cep"),
                            obj.getString("logradouro"),
                            obj.getString("complemento"),
                            obj.getString("bairro"),
                            obj.getString("localidade"),
                            obj.getString("uf"),
                            obj.getString("unidade"),
                            obj.getString("ibge"),
                            obj.getString("gia")));
                    txt1.setText("CEP: "+found.getCep());
                    txt2.setText("Logradouro: "+found.getLocalidade());
                    txt3.setText("Complemento: "+found.getComplemento());
                    txt4.setText("Bairro: "+found.getBairro());
                    txt5.setText("Localidade: "+found.getLocalidade());
                    txt6.setText("Uf: "+found.getUf());
                    txt7.setText("Unidade: "+found.getUnidade());
                    txt8.setText("Ibge: "+found.getIbge());
                    txt9.setText("Gia: "+found.getGia());

                    ArrayList<CEP> lista = ListaCEP.getInstance().getLista();
                    lista.add(found);
                    ListaCEP.getInstance().setLista(lista);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                /*
                txt1.setText("CEP: ");
                txt2.setText("Logradouro: ");
                txt3.setText("Complemento: ");
                txt4.setText("Bairro: ");
                txt5.setText("Localidade: ");
                txt6.setText("Uf: ");
                txt7.setText("Unidade: ");
                txt8.setText("Ibge: ");
                txt9.setText("Gia: ");

                txt1.setText("CEP: " + CEPObj.getCep());
                txt2.setText("Logradouro: " + CEPObj.getLogradouro());
                txt3.setText("Complemento: " + CEPObj.getComplemento());
                txt4.setText("Bairro: " + CEPObj.getBairro());
                txt5.setText("Localidade: " + CEPObj.getLocalidade());
                txt6.setText("Uf: " + CEPObj.getUf());
                txt7.setText("Unidade: " + CEPObj.getUnidade());
                txt8.setText("Ibge: " + CEPObj.getIbge());
                txt9.setText("Gia: " + CEPObj.getGia());
                */
            }
        });
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt1 = (TextView) findViewById(R.id.textView);
        TextView txt2 = (TextView) findViewById(R.id.textView2);
        TextView txt3 = (TextView) findViewById(R.id.textView3);
        TextView txt4 = (TextView) findViewById(R.id.textView4);
        TextView txt5 = (TextView) findViewById(R.id.textView5);
        TextView txt6 = (TextView) findViewById(R.id.textView6);
        TextView txt7 = (TextView) findViewById(R.id.textView7);
        TextView txt8 = (TextView) findViewById(R.id.textView8);
        TextView txt9 = (TextView) findViewById(R.id.textView9);
        txt1.setText("CEP: ");
        txt2.setText("Logradouro: ");
        txt3.setText("Complemento: ");
        txt4.setText("Bairro: ");
        txt5.setText("Localidade: ");
        txt6.setText("Uf: ");
        txt7.setText("Unidade: ");
        txt8.setText("Ibge: ");
        txt9.setText("Gia: ");
    }*/

    public void onClickSearch(View view) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        EditText cep = view.findViewById(R.id.txtCep);
        //ConnectionCEP ConnectionCEP = new ConnectionCEP();
        //CEP CEPObj = ConnectionCEP.getCepConnection(cep.getText().toString());

        TextView txt1 = view.findViewById(R.id.textView);
        TextView txt2 = view.findViewById(R.id.textView2);
        TextView txt3 = view.findViewById(R.id.textView3);
        TextView txt4 = view.findViewById(R.id.textView4);
        TextView txt5 = view.findViewById(R.id.textView5);
        TextView txt6 = view.findViewById(R.id.textView6);
        TextView txt7 = view.findViewById(R.id.textView7);
        TextView txt8 = view.findViewById(R.id.textView8);
        TextView txt9 = view.findViewById(R.id.textView9);

        ConnectionAdress connectionAdress = new ConnectionAdress();
        CEP CEPObj = null;
        try {
            CEPObj = connectionAdress.sendGet(cep.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }



        /*funfa
        ConnectionAdress connectionAdress = new ConnectionAdress();
        try {
            txt1.setText(connectionAdress.retorna(cep.getText().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            StringBuffer response = connectionAdress.retorna(cep.getText().toString());
            JSONObject obj = new JSONObject(response.toString());
            CEP found = (new CEP(obj.getString("cep"),
                    obj.getString("logradouro"),
                    obj.getString("complemento"),
                    obj.getString("bairro"),
                    obj.getString("localidade"),
                    obj.getString("uf"),
                    obj.getString("unidade"),
                    obj.getString("ibge"),
                    obj.getString("gia")));
            txt1.setText("CEP: "+found.ConnectionCEP());
            txt2.setText("Logradouro: "+found.getLocalidade());
            txt3.setText("Complemento: "+found.getComplemento());
            txt4.setText("Bairro: "+found.getBairro());
            txt5.setText("Localidade: "+found.getLocalidade());
            txt6.setText("Uf: "+found.getUf());
            txt7.setText("Unidade: "+found.getUnidade());
            txt8.setText("Ibge: "+found.getIbge());
            txt9.setText("Gia: "+found.getGia());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        /*txt1.setText("CEP: ");
        txt2.setText("Logradouro: ");
        txt3.setText("Complemento: ");
        txt4.setText("Bairro: ");
        txt5.setText("Localidade: ");
        txt6.setText("Uf: ");
        txt7.setText("Unidade: ");
        txt8.setText("Ibge: ");
        txt9.setText("Gia: ");*/

        txt1.setText("CEP: " + CEPObj.getCep());
        txt2.setText("Logradouro: " + CEPObj.getLogradouro());
        txt3.setText("Complemento: " + CEPObj.getComplemento());
        txt4.setText("Bairro: " + CEPObj.getBairro());
        txt5.setText("Localidade: " + CEPObj.getLocalidade());
        txt6.setText("Uf: " + CEPObj.getUf());
        txt7.setText("Unidade: " + CEPObj.getUnidade());
        txt8.setText("Ibge: " + CEPObj.getIbge());
        txt9.setText("Gia: " + CEPObj.getGia());
    }
}