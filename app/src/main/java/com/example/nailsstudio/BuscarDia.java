package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

public class BuscarDia extends AppCompatActivity {

    private CalendarView cal;
    private String fecha;
    private int dia, mes, anio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_dia);
        cal = findViewById(R.id.calendarView3);

        cal.setOnDateChangeListener((view, year,month, dayOfMonth)->{
            fecha = dayOfMonth + "/" + (month+1) +  "/" + year;
            dia = dayOfMonth;
            mes = month;
            anio = year;
            Toast.makeText(this,fecha,Toast.LENGTH_SHORT).show();
        });

    }


    public void darBuscar(View view){
        Intent intent = new Intent(this, CitasActivity.class);
        intent.putExtra("year",anio);
        intent.putExtra("month", mes);
        intent.putExtra("day", dia);
        startActivity(intent);
    }
}