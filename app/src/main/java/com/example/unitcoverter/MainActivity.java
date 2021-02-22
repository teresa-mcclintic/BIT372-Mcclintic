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
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.unitcoverter.databinding.ActivityMainBinding;

import java.util.Objects;

import static com.example.unitcoverter.BR.viewmodel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText conversionIn;
    private TextView conversionOut;

    public String conversionFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Button convert_btn = findViewById(R.id.convert_btn);
        //TextView ctxt = findViewById(R.id.unit_text);
        MyViewModel vm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        vm.value2convert.setValue("");
        vm.getValue2Convert().observe(this, value -> {
            Log.i("INFO", value);

                });



        vm.getConvertedObservable().observe(this, done -> {
            Log.i("INFO", done);
        });

        String getValue  = vm.value2convert.getValue();
        vm.setConverted(getValue);
       ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setViewmodel(vm);



        //EditText convert_input = findViewById(R.id.unit_input);
        //TextView ctxt = findViewById(R.id.unit_text);


        Button convert_btn = findViewById(R.id.convert_btn);
        TextView ctxt = findViewById(R.id.unit_text);

        //An adapter to convert the String[] into something that can go in the Spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner conversionSpinner = (Spinner) findViewById(R.id.conversion_type);
        conversionSpinner.setAdapter(adapter);



       convert_btn.setOnClickListener(v -> {
           conversionFactor = (String) conversionSpinner.getSelectedItem();
           Log.i("Info", conversionFactor);


          if (vm.value2convert == null) {
              return;

          }
           else if (conversionFactor.equals("Fahrenheit to Celsius")) {

               double celcius = Converter.toCelcius(Float.parseFloat(vm.value2convert.getValue()));
               Log.i("INFO", String.valueOf(celcius));
               String convertedText = String.format("%.1f ºC", celcius);
               ctxt.setText("ºF is "+convertedText);
               vm.setConverted(convertedText);



            }else if (conversionFactor.equals("Pounds to Kilograms")) {
                double kilo = Converter.toKilogram(Float.parseFloat(Objects.requireNonNull(vm.value2convert.getValue())));
                String convertedText = String.format("%.1f kg", kilo);
                ctxt.setText("lb is "+convertedText);

            }else if(conversionFactor.equals("Quarts to Liters")) {
                double liter = Converter.toLiters(Float.parseFloat(Objects.requireNonNull(vm.value2convert.getValue())));
                String convertedText = String.format("%.1f L", liter);
                ctxt.setText("Qt is "+convertedText);

            }else if (conversionFactor.equals("Inches to Centimeters")){
                double cm = Converter.toCentimeters(Float.parseFloat(Objects.requireNonNull(vm.value2convert.getValue())));
                String convertedText = String.format("%.1f cm", cm);
                ctxt.setText("in is "+convertedText);;
            }



       });
    }
}