package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewTreeViewModelKt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    public void dar_aceptar2(View view) {
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();
        String hora = hour + ":" + minute;

        // Recuperar la fecha seleccionada de la actividad anterior
        int year = getIntent().getIntExtra("year", 0);
        int month = getIntent().getIntExtra("month", 0);
        int day = getIntent().getIntExtra("day", 0);

        // Combinar la fecha y la hora para tener un formato completo
        String fechaHora = year + "-" + month + "-" + day + " " + hora;

        // Verificar si hay citas existentes en el rango de tiempo seleccionado
        if (!citasSeSobreponen(year, month, day, hour, minute)) {
            // No hay citas que se sobrepongan, puedes agregar la nueva cita
            Toast.makeText(this, "Cita programada: " + fechaHora, Toast.LENGTH_SHORT).show();

            // Crear una nueva intención para pasar la fecha y hora seleccionadas a la siguiente actividad
            Intent intent = new Intent(this, DetallesCita.class);
            intent.putExtra("year", year);
            intent.putExtra("month", month);
            intent.putExtra("day", day);
            intent.putExtra("hour", hour);
            intent.putExtra("minute", minute);
            startActivity(intent);
        } else {
            // Hay citas que se sobreponen, mostrar un mensaje de error
            Toast.makeText(this, "Se sobrepone con otra cita", Toast.LENGTH_SHORT).show();
        }
    }



    public boolean citasSeSobreponen(int year1, int month1, int day1, int hour1, int minute1) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        // Combinar la fecha y la hora para tener un formato completo
        String nuevaFechaHora = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1;

        // Realizar una consulta para verificar si hay citas que se sobreponen
        Cursor cursorCitas = baseDeDatos.rawQuery("SELECT * FROM citas WHERE fecha = ? AND hora = ?",
                new String[]{year1 + "-" + month1 + "-" + day1, hour1 + ":" + minute1});

        // Verificar si el cursor tiene alguna fila (es decir, hay una cita existente en ese momento)
        boolean seSobreponen = true;
        seSobreponen = cursorCitas.getCount() > 0;

        // Cerrar el cursor y la base de datos
        cursorCitas.close();
        baseDeDatos.close();

        return seSobreponen;
    }


    public void darCancelar2(View view){
        Intent anterior =new Intent(this, AgregarDia.class);
        startActivity(anterior);
    }


}

