package com.example.nailsstudio.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nailsstudio.AgregarDia;
import com.example.nailsstudio.R;

public class MainActivity_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //ola m
    }

    public void Boton_agregar(View view){
        Intent b_agregar = new Intent(this, AgregarDia.class);
        startActivity(b_agregar);
    }
}