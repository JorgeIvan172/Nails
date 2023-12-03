package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nailsstudio.ui.main.MainActivity_Menu;

public class DetallesCita extends AppCompatActivity {

    private EditText nombre_cliente, numero_cliente;
    private Spinner spinner1;
    //private RadioButton rb_gelish, rb_acrilico, rb_pestanas, rb_pedicure;
    private RadioGroup radioGroup;
    private String nombreCliente;
    private String numeroCliente;
    private String tipoCita;
    private String tipoPago;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);
        nombre_cliente = findViewById(R.id.et_nombreCliente);
        numero_cliente = findViewById(R.id.editTextPhone);

        /*rb_acrilico = findViewById(R.id.rb_acrilico);
        rb_gelish = findViewById(R.id.rb_gelish);
        rb_pestanas = findViewById(R.id.rb_pestanas);
        rb_pedicure = findViewById(R.id.rb_pedicure);
         */

        spinner1 = findViewById(R.id.spinner);
        String [] opcionesPago={"Tarjeta", "Efectivo", "Efectivo y Tarjeta"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesPago);
        spinner1.setAdapter(adapter);

        radioGroup = findViewById(R.id.radioGroup);

    }
        //aqui solo toma los datos y los muestra en un toast aun no guarda nada
    public void wardar(View view){
        String nombreCliente = nombre_cliente.getText().toString();
        String numeroCliente = numero_cliente.getText().toString();
        String tipoCita = "";
        String tipoPago = spinner1.getSelectedItem().toString();



        Intent intent = getIntent();
        int year = intent.getIntExtra("year", 0);
        int month = intent.getIntExtra("month", 0);
        int day = intent.getIntExtra("day", 0);
        int hour = intent.getIntExtra("hour", 0);
        int minute = intent.getIntExtra("minute", 0);

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            tipoCita = selectedRadioButton.getText().toString();

        } else {
            Toast.makeText(this,
                    "Ingresa un tipo de cita"  , Toast.LENGTH_LONG).show();
        }


        if (!nombreCliente.isEmpty() && !numeroCliente.isEmpty() && !tipoCita.isEmpty()){
            Insertar(nombreCliente, numeroCliente,tipoCita,tipoPago,year,month,day,hour,minute);
        }

    }


    public void Insertar(String nombreCliente, String numeroCliente, String tipoCita, String tipoPago,
                         int year, int month, int day, int hour, int minute) {


        this.nombreCliente = nombreCliente;
        this.numeroCliente = numeroCliente;
        this.tipoCita = tipoCita;
        this.tipoPago = tipoPago;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;

        String horabd= hour + ":" + minute;
        String fechabd = year + "-" + month + "-" + day;
        int precio = 0;
        String preciodb= null;
        String duracion = null;

        if("Uñas Acrilico".equals(tipoCita)) {
            precio=240;
            duracion="90";
            preciodb = precio+"";
        } else if ("Gelish".equals(tipoCita)) {
         precio=85;
         duracion = "45";
         preciodb = precio+"";
        } else if ("Pestañas".equals(tipoCita)) {
            precio=400;
            duracion = "90";
            preciodb = precio+"";
        } else if ("Pedicure".equals(tipoCita)) {
            precio=250;
            duracion = "60";
            preciodb = precio+"";
        }



        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nombreCliente",nombreCliente );
        registro.put("telefonoCliente", numeroCliente);
        registro.put("hora", horabd );
        registro.put("fecha", fechabd);
        registro.put("tipoCita", tipoCita);
        registro.put("metodoPago", tipoCita);
        registro.put("duracion", duracion );
        registro.put("costoCita", preciodb);

        BaseDeDatos.insert("citas", null, registro);
        BaseDeDatos.close();

        Toast.makeText(this,
                "Se ha guardado la cita"  , Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, MainActivity_Menu.class);
        startActivity(i);

    }



}