package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewTreeViewModelKt;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.nailsstudio.ui.main.MainActivity_Menu;

public class Hora_agregar extends AppCompatActivity {

    private TimePicker timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora_agregar);

        timePicker = findViewById(R.id.timePicker);
    }

    public void dar_aceptar2(View view){
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();
        String hora = hour + ":" + minute + "";

        Toast.makeText(this,hora,Toast.LENGTH_SHORT).show();

        // Recuperar la fecha seleccionada de la actividad anterior
        int year = getIntent().getIntExtra("year", 0);
        int month = getIntent().getIntExtra("month", 0);
        int day = getIntent().getIntExtra("day", 0);

        // Crear una nueva intención para pasar la fecha y hora seleccionadas a la siguiente actividad
        Intent intent = new Intent(this, DetallesCita.class);
        intent.putExtra("year", year);
        intent.putExtra("month", month);
        intent.putExtra("day", day);
        intent.putExtra("hour", hour);
        intent.putExtra("minute", minute);
        startActivity(intent);
    }

    public void darCancelar2(View view){
        Intent anterior =new Intent(this, AgregarDia.class);
        startActivity(anterior);
    }


}