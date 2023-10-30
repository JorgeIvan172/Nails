package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class AgregarDia extends AppCompatActivity {

    CalendarView cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_dia);

        cal = findViewById(R.id.calendarView2);

        cal.setOnDateChangeListener((view, year,month, dayOfMonth)->{
            String fecha = dayOfMonth + "/" + (month+1) +  "/" + year;
             //int dia = dayOfMonthint
            //mes = month;
            // int anio = year;
            Toast.makeText(this,fecha,Toast.LENGTH_SHORT).show();
        });
    }

}