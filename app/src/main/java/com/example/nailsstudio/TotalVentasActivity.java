package com.example.nailsstudio;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;




public class TotalVentasActivity extends AppCompatActivity {

    private TextView textViewSumaCosto;
    private String fechaA;

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_ventas);

        textViewSumaCosto = findViewById(R.id.textViewSumaCosto);


        calendar = Calendar.getInstance();
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        // Formatea manualmente la fecha
        String formattedMonth = (month + 1) < 10 ? "0" + (month + 1) : String.valueOf(month + 1);
        String formattedDay = dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth);

        String fechaSeleccionada = year + "-" + formattedMonth + "-" + formattedDay;
        fechaA = fechaSeleccionada;
        textViewSumaCosto.setText("Fecha seleccionada: " + fechaSeleccionada);

        // Calcula y muestra la suma del costo de citas para la fecha seleccionada
        double sumaCostoCitas = obtenerSumaCostoCitas(fechaSeleccionada);
        textViewSumaCosto.append("\nSuma del costo de citas: $" + sumaCostoCitas);
    }


    private double obtenerSumaCostoCitas(String fecha) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        // Realiza la consulta SQL para obtener la suma del costo de las citas para una fecha específica
        String query = "SELECT SUM(costoCita) FROM citas WHERE fecha = ?";
        Cursor cursorventas = BaseDeDatos.rawQuery("SELECT SUM(costoCita) FROM Citas WHERE fecha ='"+ fechaA + "'" , null);

        double sumaCosto = 0;

        if (cursorventas.moveToFirst()) {
            sumaCosto = cursorventas.getDouble(0);
            Log.d("TAG", "Si entro al if");
        }

        cursorventas.close();

        //Aqui agregue depuracion
        String queryAll = "SELECT * FROM citas WHERE fecha = ?";
        Cursor cursorAll = BaseDeDatos.rawQuery("SELECT * FROM Citas", null);

        Log.d("TAG", "AUn noEntre while ");
        while (cursorAll.moveToNext()) {
            Log.d("TAG", "SI Entre while ");
            int nombreClienteIndex = cursorAll.getColumnIndex("nombreCliente");
            if (nombreClienteIndex >= 0) {
                String nombreCliente = cursorAll.getString(nombreClienteIndex);
                // Agrega más líneas para recuperar otros valores

                Log.d("TAG", "Cita encontrada - Nombre: " + nombreCliente);
            } else {
                Log.e("TAG", "La columna 'nombreCliente' no existe en el conjunto de resultados.");
            }
        }

        cursorAll.close();

        //aqui acabo depuracion
        BaseDeDatos.close();

        // Agrega mensajes de depuración
        Log.d("TAG", "Consulta SQL para la suma: " + query);
        Log.d("TAG", "Fecha para la suma: " + fecha);
        Log.d("TAG", "Suma del costo de citas: " + sumaCosto);

        return sumaCosto;
    }
}



