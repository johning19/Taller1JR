package com.example.taller1jr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvdato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar rango = findViewById(R.id.barrarango);
        tvdato = (TextView) findViewById(R.id.tvValorRango);

        rango.setProgress(10);
        tvdato.setText(""+rango.getProgress());

        rango.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        tvdato.setText(""+ i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }



    //Metodo para ir al juego adivinar numeros y enviar valor de rango

    public void numeros(View view){
        Intent juego = new Intent(MainActivity.this,JuegoNumeros.class);
        juego.putExtra("dato",tvdato.getText().toString());
        startActivity(juego);
    }

    //Medodo para ir activity buscar paises

    public void buscarpais(View view){
        Intent buscar = new Intent(MainActivity.this,Paises.class);
        startActivity(buscar);
    }


}