package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.nailsstudio.ui.main.CalendarioAgregarFragment;

public class Calendario_agregar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_agregar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CalendarioAgregarFragment.newInstance())
                    .commitNow();
        }
    }
}