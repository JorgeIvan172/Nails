package com.example.nailsstudio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.nailsstudio.entidades.Citas;

import java.util.ArrayList;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table citas(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombreCliente TEXT,"
                + "telefonoCliente TEXT,"
                + "hora TEXT,"
                + "fecha TEXT,"
                + "tipoCita TEXT,"
                + "metodoPago TEXT,"
                + "duracion TEXT,"
                + "costoCita Real"
                + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
