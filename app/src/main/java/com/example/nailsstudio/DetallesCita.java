package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class DetallesCita extends AppCompatActivity {

    private EditText nombre_cliente, numero_cliente;
    private Spinner spinner1;
    private RadioButton rb_gelish, rb_acrilico, rb_pestanas, rb_pedicure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);
        nombre_cliente = findViewById(R.id.et_nombreCliente);
        numero_cliente = findViewById(R.id.editTextPhone);

        rb_acrilico = findViewById(R.id.rb_acrilico);
        rb_gelish = findViewById(R.id.rb_gelish);
        rb_pestanas = findViewById(R.id.rb_pestanas);
        rb_pedicure = findViewById(R.id.rb_pedicure);

        spinner1 = findViewById(R.id.spinner);
        String [] opcionesPago={"Tarjeta", "Efectivo", "Efectivo y Tarjeta"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesPago);
        spinner1.setAdapter(adapter);

    }

    public void wardar(View view){
        String nombreCliente = nombre_cliente.toString();
        String numeroCliente = numero_cliente.toString();
        String tipoCita = "";
        String tipoPago = spinner1.getSelectedItem().toString();

        if (rb_acrilico.isChecked()){
            tipoCita = rb_acrilico.toString();
        } else if (rb_gelish.isChecked()) {
            tipoCita = rb_gelish.toString();
        }else if (rb_pestanas.isChecked()){
            tipoCita = rb_pestanas.toString();
        }else if (rb_pedicure.isChecked()){
            tipoCita = rb_pedicure.toString();
        }

        Toast.makeText(this,
                "Cita Guardada Como:", Toast.LENGTH_LONG).show();
        Toast.makeText(this,
                nombreCliente  +" "+ numeroCliente + " " + tipoCita +" " + tipoPago + " " + " Se ha Guardado", Toast.LENGTH_LONG).show();
    }
}