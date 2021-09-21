package com.example.taller1jr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Paises extends AppCompatActivity {

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    ListView listpais;
    ArrayList<String> Pais = new ArrayList<>();
    ArrayList<String> Capital = new ArrayList<>();
    ArrayList<String> Siglas = new ArrayList<>();
    ArrayList<String> Nombre = new ArrayList<>();
    ArrayList<String> Banderas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        listpais = (ListView) findViewById(R.id.listapaises);

        try {
            JSONObject json = new JSONObject(loadJSONFromAsset());
            JSONArray paisesJsonArray = json.getJSONArray("paises");

            for(int i=0;i<paisesJsonArray.length();i++){
                JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
                String listapais = jsonObject.getString("nombre_pais");
                String listacapital = jsonObject.getString("capital");
                String listanombre = jsonObject.getString("nombre_pais_int");
                String listasiglas = jsonObject.getString("sigla");
                String listabanderas = jsonObject.getString("url");
                Pais.add(listapais);
                Capital.add(listacapital);
                Siglas.add(listasiglas);
                Nombre.add(listanombre);
                Banderas.add(listabanderas);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Pais);
            listpais.setAdapter(adapter);

            listpais.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent detalle = new Intent(getBaseContext(), DetallePais.class);
                    detalle.putExtra("Pais", Pais.get(i));
                    detalle.putExtra("Capital", Capital.get(i));
                    detalle.putExtra("Siglas", Siglas.get(i));
                    detalle.putExtra("Nombre", Nombre.get(i));
                    detalle.putExtra("Banderas", Banderas.get(i));
                    startActivity(detalle);
                }
            });


        }catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void volverp(View view){
        Intent volverpais = new Intent(Paises.this,MainActivity.class);
        startActivity(volverpais);
    }
}