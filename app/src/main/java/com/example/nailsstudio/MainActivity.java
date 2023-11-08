package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nailsstudio.ui.main.MainActivity_Menu;

public class MainActivity extends AppCompatActivity {

    private EditText et_1, et_2;
    private CheckBox cb_recuerdame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_1 = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);
        cb_recuerdame = findViewById(R.id.checkBox);
    }


    //Método para el botón
    public void Login(View view){

        String nombre = et_1.getText().toString();
        String passward = et_2.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(this,
                    "Debes de ingresar tu email", Toast.LENGTH_LONG).show();
        }
        if(passward.length() == 0){
            Toast.makeText(this,
                    "Debes de ingresar tu password", Toast.LENGTH_LONG).show();
        }
       if(nombre.length() != 0 && passward.length() != 0){

            Toast.makeText(this,
                    "Login...", Toast.LENGTH_LONG).show();
            Intent menu = new Intent(this, MainActivity_Menu.class);
            startActivity(menu);
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