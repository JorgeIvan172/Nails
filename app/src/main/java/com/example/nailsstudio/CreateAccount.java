package com.example.nailsstudio;

import static com.example.nailsstudio.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    private EditText etnombre, etemail, etpassword, etcpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_create_account);

        etnombre = (EditText)findViewById(R.id.et_nombre);
        etemail = (EditText) findViewById(R.id.et_email);
        etpassword = (EditText) findViewById(R.id.et_password);
        etcpassword = (EditText) findViewById(id.et_cpassword);
    }


    public void createAccount(View view){

        String nombre = etnombre.getText().toString();
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();
        String cpassword = etcpassword.getText().toString();


        //Si alguno de los campos esta vacio te pide que los llene
        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty() || cpassword.isEmpty()){
            Toast.makeText(this,
                    "Rellena Los Campos", Toast.LENGTH_LONG).show();
        }
        //Si todos los campos estan llenos:
        else {
            //Si la confirmacion de contraseña no es igual a la contraseña te pedira que lo hagas correctamente
            if (!password.equals(cpassword)){
                Toast.makeText(this,
                        "La contraseña no coincide", Toast.LENGTH_LONG).show();
            }
            //Si los campos de contraseña y confirmacion son iguales procedera:
            else{
                Toast.makeText(this,
                        "Cuenta Creada", Toast.LENGTH_LONG).show();
            }

        }
    }
}