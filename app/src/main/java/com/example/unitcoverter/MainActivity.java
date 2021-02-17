package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        //Button kbtn = findViewById(R.id.convert_btn2);

        EditText convert_input = findViewById(R.id.unit_input);
        TextView ctxt = findViewById(R.id.unit_text);
        //EditText pinput = findViewById(R.id.pounds_input2);
        //TextView ktxt = findViewById(R.id.kilo_text2);


      // An adapter to convert the String[] into something that can go in the Spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner conversionSpinner = (Spinner) findViewById(R.id.conversion_type);
        conversionSpinner.setAdapter(adapter);



        fbtn.setOnClickListener(v -> {
            String conversionFactor = (String) conversionSpinner.getSelectedItem();
            Log.i("Info",conversionFactor);

            if (convert_input.getText().length() == 0){
                return;}
            if (conversionFactor.equals("Fahrenheit to Celsius")) {
                double celcius = Converter.toCelcius(Float.parseFloat(convert_input.getText().toString()));

                ctxt.setText(String.format("%.2f ºC", celcius));
            }else if (conversionFactor.equals("Pounds to Kilograms")) {
                double kilo = Converter.toKilogram(Float.parseFloat(convert_input.getText().toString()));
                ctxt.setText(String.format("%.2f kg", kilo));

            }else if(conversionFactor.equals("Quarts to Liters")) {
                double liter = Converter.toLiters(Float.parseFloat(convert_input.getText().toString()));
                ctxt.setText(String.format("%.2f liters", liter));

            }else if (conversionFactor.equals("Inches to Centimeters")) {
                double cm = Converter.toCentimeters(Float.parseFloat(convert_input.getText().toString()));
                ctxt.setText(String.format("%.2f cm", cm));
            }
        });

    }
}