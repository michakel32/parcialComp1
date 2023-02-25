package com.example.parcialc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Definimos los objetos.
    Spinner Lista_Carrera;
    Spinner Lista_Tipo;
    EditText Ingre_CuotaStandar, Ingre_Cum;
    Button Visualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Referenciamos los objetos.
        Lista_Carrera = findViewById(R.id.Lista_Carrera);
        Lista_Tipo = findViewById(R.id.Tipo_Uni);
        Ingre_CuotaStandar = findViewById(R.id.Edicuota);
        Ingre_Cum = findViewById(R.id.EdiCum);
        Visualizar = findViewById(R.id.VerDatos);
        // Creamos los datos a los 2 spinner.
        String[] Carrera = {"Ingeniería En Manejo y Gestión de Base De Datos", "Ingeniería En Sistemas","Técnico en Sistemas"};
        ArrayAdapter<String> VerCarrera = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Carrera);
        Lista_Carrera.setAdapter(VerCarrera);
        String[] Tipo = {"Pública", "Privada"};
        ArrayAdapter<String> VerTipo = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Tipo);
        Lista_Tipo.setAdapter(VerTipo);
        // Damos función al botón.
        Visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Llamaremos al método que obtiene los datos.
                Datos_Arranceles();
            }
        });
    }
    // Se crea el método en el se realizarán los cálculos
    // del enunciado.
    public void Datos_Arranceles() {
        // String para los 2 Spinner.
        String op1, op2;
        // Variables a necesitar del enunciado.
        double cuotaS=0, Cum, aumento = 0, descuento = 0, Institucion_Descuento = 0, Apagar=0;
        cuotaS = Double.parseDouble(Ingre_CuotaStandar.getText().toString());
        Cum = Double.parseDouble(Ingre_Cum.getText().toString());
        // Obtener datos del primer Spinner.
        op1 = Lista_Carrera.getSelectedItem().toString();
        // Obtener datos del segundo Spinner.
        op2 = Lista_Tipo.getSelectedItem().toString();
        // Condición al primer Spinner al seleccionar su carrera.
        if (op1.equals("Ingeniería En Manejo y Gestión de Base De Datos")) {
            aumento = cuotaS * 0.30 + 20;
        } else if (op1.equals("Ingeniería En Sistemas")) {
            aumento = cuotaS * 0.40 + 25;
        } else if (op1.equals("Técnico en Sistemas")) {
            aumento = cuotaS * 0.45 + 30;
        }
        // Condición al dato Cum.
        if (Cum >= 9) {
            descuento = cuotaS * 0.25;
        } else if (Cum >= 8) {
            descuento = cuotaS * 0.20;
        } else if (Cum >= 7) {
            descuento = cuotaS * 0.15;
        }
        // Condición del segundo Spinner al tipo de Universidad.
        if (op2.equals("Pública")) {
            Institucion_Descuento = cuotaS * 0.05;
        } else if (op2.equals("Privada")) {
            Institucion_Descuento = cuotaS * 0.10;
        }
        // El total a pagar de dicho enunciado.
        Apagar = cuotaS + aumento - descuento - Institucion_Descuento;
        // Nos llevará a la segunda activity
        Intent Registrar = new Intent(MainActivity.this, Arranceles_Datos.class);
        // Damos Los datos con sus respectivas llaves.
        Registrar.putExtra("Carrera", op1);
        Registrar.putExtra("Tipo", op2);
        Registrar.putExtra("Cuota", cuotaS);
        Registrar.putExtra("Cum", Cum);
        Registrar.putExtra("Total", Apagar);
        // inicializamos la Activity.
        startActivity(Registrar);
        // Limpiamos los datos al momento de regresar a la 1 Activity.
        Ingre_CuotaStandar.setText("");
        Ingre_Cum.setText("");
    }
}