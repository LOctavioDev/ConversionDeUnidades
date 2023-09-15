package com.example.conversiondeunidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etDistance;
    private Spinner spinnerUnits;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDistance = findViewById(R.id.etDistance);
        spinnerUnits = findViewById(R.id.spinnerUnits);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);

        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.distance_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnits.setAdapter(adapter);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDistance();
            }
        });
    }

    private void convertDistance() {
        try {
            double meters = Double.parseDouble(etDistance.getText().toString());
            String selectedUnit = spinnerUnits.getSelectedItem().toString();
            double result;

            switch (selectedUnit) {
                case "Kilómetros":
                    result = meters / 1000.0;
                    break;
                case "Millas":
                    result = meters * 0.000621371;
                    break;
                case "Pies":
                    result = meters * 3.28084;
                    break;
                default:
                    result = 0.0;
            }

            tvResult.setText("Resultado: " + result);
        } catch (NumberFormatException e) {
            // Manejar el caso en el que la entrada no sea un número válido.
            tvResult.setText("Resultado: ");
        }
    }
}