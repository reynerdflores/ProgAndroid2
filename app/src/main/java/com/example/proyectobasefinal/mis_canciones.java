package com.example.proyectobasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import OBJETOS.CANCIONES;

public class mis_canciones extends AppCompatActivity {

    private Spinner canciones;
    private TextView resultado;
    private RatingBar calificacion;
    CANCIONES can = new CANCIONES();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_canciones);

        canciones = findViewById(R.id.spncan);
        resultado = findViewById(R.id.result);
        calificacion = findViewById(R.id.RB);

        Bundle buna = getIntent().getExtras();
        String[] listado = buna.getStringArray("CANCIONES");

        //String[] listado = {"Don't start now", "Mercy", "Issues", "Toxic"};
        ArrayAdapter adaptCanciones = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        canciones.setAdapter(adaptCanciones);
    }

    public void Calcular (View view)
    {
        int opcion = canciones.getSelectedItemPosition();
        String nombre = can.getCanciones()[opcion];
        String cantante = can.getCantante()[opcion];
        int precio = can.getPrecios()[opcion];
        precio = can.anadirAdicional(precio, 50);
        int estrella = can.getCalificacion()[opcion];
        calificacion.setRating(estrella);

 
        resultado.setText("La opción es: " + nombre + "\nEl cantante es: " + cantante + "\nEl precio es: " + precio);
    }
}