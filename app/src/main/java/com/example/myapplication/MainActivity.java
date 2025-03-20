package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private TextView textViewSaludo;
    private RadioButton radioButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configurar TextView
        textViewSaludo = findViewById(R.id.textViewSaludo);
        textViewSaludo.setText("Seleccione la hora para ver el saludo");
        textViewSaludo.setTextColor(Color.BLACK);
        textViewSaludo.setTextSize(20);
        textViewSaludo.setPadding(20, 20, 20, 20);
        textViewSaludo.setBackgroundColor(Color.parseColor("#E0E0E0"));

        // Configurar RadioButton
        radioButton = findViewById(R.id.radioButtonControl);
        radioButton.setText("Seleccionar opción");
        radioButton.setTextColor(Color.BLUE);
        radioButton.setTextSize(16);
        radioButton.setChecked(true);
        radioButton.setGravity(2);


        timePicker = findViewById(R.id.timePicker);
        textViewSaludo = findViewById(R.id.textViewSaludo);

        // Configurar TimePicker
        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            actualizarSaludo(hourOfDay);
        });


    }

    // Actualizar el saludo según la hora
    private void actualizarSaludo(int hourOfDay) {
        if (hourOfDay >= 5 && hourOfDay <= 12) {
            textViewSaludo.setText("¡Buenos días! Inicia sesión");
            textViewSaludo.setTextColor(Color.parseColor("#FF9800")); // Naranja
        } else if (hourOfDay >= 12 && hourOfDay <= 18) {
            textViewSaludo.setText("¡Buenas tardes! Inicia sesión");
            textViewSaludo.setTextColor(Color.parseColor("#2196F3")); // Azul
        } else {
            textViewSaludo.setText("¡Buenas noches! Inicia sesión");
            textViewSaludo.setTextColor(Color.parseColor("#673AB7")); // Violeta
        }
    }
}
