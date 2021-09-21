package com.example.taller1jr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class JuegoNumeros extends AppCompatActivity implements View.OnClickListener {

    private EditText et1;
    private TextView tv1;
    private TextView tv2;
    private TextView tv_rango;
    private Button btnSumar;
    private int aleatorio;
    private int i = 0;
    private ListView Lista;
    public String contador;
    private String valor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_numeros);
        et1 = (EditText)findViewById(R.id.txt_numero);
        tv1 = (TextView) findViewById(R.id.txt_resultado);
        tv2 = (TextView) findViewById(R.id.txt_intentos);
        btnSumar = (Button) findViewById(R.id.button);
        btnSumar.setOnClickListener(this);
        String dato = getIntent().getStringExtra("dato");
        int datoentero = Integer.parseInt(dato);
        aleatorio = (int) ((Math.random()*datoentero)+0);
        Lista = (ListView) findViewById(R.id.ListaIntentos);

        tv_rango = (TextView) findViewById(R.id.textViewRango);
        tv_rango.setText("Adivina un numero entre 0 y " + datoentero);
    }

    public void volver(View view){
        Intent volverjuego = new Intent(JuegoNumeros.this,MainActivity.class);
        startActivity(volverjuego);
    }

    @Override
    public void onClick(View view) {
        valor1 = et1.getText().toString();
        String result;
        i++;
        int num1 = Integer.parseInt(valor1);

        if (num1 == aleatorio) {
            result = "Tu numero es Igual";
            tv1.setText(result);
        }

        if (num1 > aleatorio) {
            result = "Tu numero es Mayor";
            tv1.setText(result);
        }

        if (num1 < aleatorio) {
            result = "Tu numero es Menor";
            tv1.setText(result);
        }

        contador = String.valueOf(i);
        tv2.setText(contador);

        ArrayList<String> arreglo =new ArrayList<>();
        for(int j=1; j<=i; j++){
            arreglo.add("Intento: " + j + "  :" + num1);
        }
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arreglo);
        Lista.setAdapter(adaptador);

    }
}