package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

public class AgregarDia extends AppCompatActivity {

    private CalendarView cal;
    private String fecha;
    private int dia, mes, anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_dia);

        cal = findViewById(R.id.calendarView2);

        cal.setOnDateChangeListener((view, year,month, dayOfMonth)->{
            fecha = dayOfMonth + "/" + (month+1) +  "/" + year;
            dia = dayOfMonth;
            mes = month;
            anio = year;
            Toast.makeText(this,fecha,Toast.LENGTH_SHORT).show();
        });
    }

    public void darAceptar(View view){
        Intent intent = new Intent(this, Hora_agregar.class);
        intent.putExtra("year",anio);
        intent.putExtra("month", mes);
        intent.putExtra("day", dia);
        startActivity(intent);
    }



}