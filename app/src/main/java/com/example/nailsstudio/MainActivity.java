package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;


import com.example.nailsstudio.ui.main.MainActivity_Menu;

public class MainActivity extends AppCompatActivity {

    private EditText et_1, et_2;
    private CheckBox cb_recuerdame;
    private SharedPreferences sharedPreferences;

    private String eml= "esmegarza@gmail.com";
    private String passwrd= "011486";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_1 = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);
        cb_recuerdame = findViewById(R.id.checkBox);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        cb_recuerdame.setChecked(sharedPreferences.getBoolean("remember", false));
        if ((cb_recuerdame.isChecked())){
            // Recuperar datos guardados (si existen)
            et_1.setText(sharedPreferences.getString("email", ""));
            et_2.setText(sharedPreferences.getString("password", ""));
            cb_recuerdame.setChecked(sharedPreferences.getBoolean("remember", false));
        }
    }


    //Método para el botón
    public void Login(View view){

        String nombre = et_1.getText().toString().toLowerCase();
        String password = et_2.getText().toString();

        if (nombre.length() == 0 || password.length() == 0) {
            Toast.makeText(this, "Debes ingresar tu email y contraseña", Toast.LENGTH_LONG).show();
        } else {
            // Guardar datos en SharedPreferences si "Recordar" está marcado
           if (nombre.equals(eml) && password.equals(passwrd)) {
               if (cb_recuerdame.isChecked()) {
                   SharedPreferences.Editor editor = sharedPreferences.edit();
                   editor.putString("email", nombre);
                   editor.putString("password", password);
                   editor.putBoolean("remember", true);
                   editor.apply();
                   Intent menu = new Intent(this, MainActivity_Menu.class);
                   startActivity(menu);
               }else {
                   SharedPreferences.Editor editor = sharedPreferences.edit();
                   editor.putBoolean("remember", false);
                   editor.apply();
                   Intent menu = new Intent(this, MainActivity_Menu.class);
                   startActivity(menu);
               }


           }if(!nombre.equals(eml)){
               Toast.makeText(this, "email mal", Toast.LENGTH_LONG).show();
           }if(!password.equals(passwrd)){
               Toast.makeText(this, "contra mal", Toast.LENGTH_LONG).show();
           }

        }
    }

    public void SignIn(View view){
        Intent cAccount = new Intent(this, CreateAccount.class);
        startActivity(cAccount);
    }

    public void VerCheckBox(View view){
        if (cb_recuerdame.isChecked()){
            Toast.makeText(this,
                    "Se te recordara", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,
                    "Ya no se te recordara", Toast.LENGTH_LONG).show();
        }
    }

    public void Info(View view){
        Intent verLaWeb = new Intent(this, VerWeb.class);
        startActivity(verLaWeb);
    }
}