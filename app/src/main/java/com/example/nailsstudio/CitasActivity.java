package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.nailsstudio.adaptadores.ListaCitaAdapter;
import com.example.nailsstudio.entidades.Citas;

import java.util.ArrayList;

public class CitasActivity extends AppCompatActivity {


    private String fechaSeleccionada;

    private RecyclerView listaCitas;
    private  ArrayList<Citas> listaArrayCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        listaCitas = findViewById(R.id.listaCitas);
        listaCitas.setLayoutManager(new LinearLayoutManager(this));

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion", null, 1);

        listaArrayCitas = new ArrayList<>();

        // Obtener la fecha seleccionada desde el intent
        Intent intent = getIntent();
        int year = intent.getIntExtra("year", 0);
        int month = intent.getIntExtra("month", 0);
        int day = intent.getIntExtra("day", 0);

        // Convertir la fecha a un formato adecuado (puedes usar SimpleDateFormat)
        fechaSeleccionada = year + "-" + month + "-" + day;

        // Obtener las citas de la base de datos para la fecha seleccionada
        listaArrayCitas = mostrarCitas();

        // Configurar y establecer el adaptador para el RecyclerView
        ListaCitaAdapter adapter = new ListaCitaAdapter(listaArrayCitas);
        listaCitas.setAdapter(adapter);


    }




    public ArrayList<Citas> mostrarCitas(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ArrayList <Citas> listaCitas = new ArrayList<>();
        Citas cita = null;
        Cursor cursorCitas = null;

        cursorCitas = BaseDeDatos.rawQuery("SELECT * FROM Citas WHERE fecha='"+ fechaSeleccionada + "'", null);

        if (cursorCitas.moveToFirst()){
            do {
                cita = new Citas();
                cita.setId(cursorCitas.getInt(0));
                cita.setNombreCliente(cursorCitas.getString(1));
                cita.setTelefonoCliente(cursorCitas.getString(2));
                cita.setHora(cursorCitas.getString(3));
                cita.setFecha(cursorCitas.getString(4));
                cita.setTipoCita(cursorCitas.getString(5));
                cita.setMetodoPago(cursorCitas.getString(6));
                cita.setDuracion(cursorCitas.getString(7));
                cita.setCostoCita(cursorCitas.getString(8));

                listaCitas.add(cita);
            }while (cursorCitas.moveToNext());
        }
        cursorCitas.close();

        return listaCitas;

    }
}