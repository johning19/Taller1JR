package com.example.taller1jr;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class DetallePais extends AppCompatActivity {

    private TextView tvpais, tvcapital, tvnombre, tvsigla;
    private ImageView ivdibujobandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pais);

        String nombres_paises= getIntent().getStringExtra("Pais");
        String nombres_capitales= getIntent().getStringExtra("Capital");
        String nombres_siglas= getIntent().getStringExtra("Siglas");
        String nombres_internacional= getIntent().getStringExtra("Nombre");
        String imagen_banderas= getIntent().getStringExtra("Banderas");

        tvpais = findViewById(R.id.tv_pais);
        tvpais.setText(nombres_paises);

        tvcapital = findViewById(R.id.tv_capital_2);
        tvcapital.setText(nombres_capitales);

        tvnombre = findViewById(R.id.tv_nombre_2);
        tvnombre.setText(nombres_internacional);

        tvsigla = findViewById(R.id.tv_siglas_2);
        tvsigla.setText(nombres_siglas);

        ivdibujobandera = findViewById(R.id.dibujobandera);
        Glide.with(this).load(imagen_banderas).into(ivdibujobandera);

    }
}