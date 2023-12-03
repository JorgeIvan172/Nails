package com.example.nailsstudio.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.nailsstudio.AgregarDia;
import com.example.nailsstudio.BuscarDia;
import com.example.nailsstudio.CitasActivity;
import com.example.nailsstudio.R;
import com.example.nailsstudio.TotalVentasActivity;

public class MainActivity_Menu extends AppCompatActivity {
    private ImageButton imageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ImageButton imageButton4 = findViewById(R.id.imageButton4);
        imageButton4.setVisibility(View.GONE);

        //ola m
    }

    public void Boton_agregar(View view){
        Intent b_agregar = new Intent(this, AgregarDia.class);
        startActivity(b_agregar);
    }


    public void BotonCitas(View view){
        Intent intent = new Intent(this, BuscarDia.class);
        startActivity(intent);
    }


    public void irATotalVentasActivity(View view) {
        Intent intent = new Intent(this, TotalVentasActivity.class);
        startActivity(intent);
    }
}