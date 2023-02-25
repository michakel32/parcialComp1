package com.example.parcialc1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Arranceles_Datos extends AppCompatActivity {
    // Declaramos los datos que necsitaremos en la segunda
    // activity.
    Button Regresar;
    TextView Ver_Carrera, Ver_Tipo, VerCuota, Ver_Cum, Ver_Total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arranceles_datos);
        // Referencias de los TextView con sus id correspondientes.
        Ver_Carrera = findViewById(R.id.MostrarCarrera);
        Ver_Tipo = findViewById(R.id.MostrarTipo);
        VerCuota = findViewById(R.id.MostrarCuota);
        Ver_Cum = findViewById(R.id.MostrarCum);
        Ver_Total = findViewById(R.id.MostrarApagar);
        // Referenciamos el boton.
        Regresar = findViewById(R.id.Nuevo);
        // Establecemos su función.
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Volver();
            }
        });
    }
    public void Volver(){
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Averiguamos si tenemos datos.
        Bundle Ver = getIntent().getExtras();
        if (Ver!=null){
            // Creamos las respectivas variable con su tipo de dato
            // con su respectiva llave asignada en el primer activity.
            String MosCarrera = Ver.getString("Carrera");
            String MosTipo = Ver.getString("Tipo");
            double couta = Ver.getDouble("Cuota");
            double cum = Ver.getDouble("Cum");
            double total = Ver.getDouble("Total");
            // Asignamos los datos a los TextView.
            Ver_Carrera.setText(MosCarrera);
            Ver_Tipo.setText(MosTipo);
            VerCuota.setText("$ "+ couta);
            Ver_Cum.setText("Nota " + cum);
            Ver_Total.setText("Pagará $ " + total);
        }
    }
}