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

import static com.example.unitcoverter.BR.viewmodel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText conversionIn;
    private TextView conversionOut;
    public Button convert_btn;
    public String conversionFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert_btn = findViewById(R.id.convert_btn);

        MyViewModel vm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);

        vm.getValue2Convert().observe(this, value -> {
            Log.i("INFO", value);

                });

        vm.setConverted("99");

        vm.getConverted().observe(this, done -> {
            Log.i("INFO", done);
        });





       ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setViewmodel(vm);



        //EditText convert_input = findViewById(R.id.unit_input);
        //TextView ctxt = findViewById(R.id.unit_text);




        // An adapter to convert the String[] into something that can go in the Spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner conversionSpinner = (Spinner) findViewById(R.id.conversion_type);
        conversionSpinner.setAdapter(adapter);



       convert_btn.setOnClickListener(v -> {
           conversionFactor = (String) conversionSpinner.getSelectedItem();
           Log.i("Info", "hello");
           String value = vm.getValue2Convert().toString();
           String converted = vm.getConverted().toString();
           Log.i("INFO",("value " + value + " converted " + converted));


           if (vm.value2convert == null) {
               return;
           }

           if (conversionFactor.equals("Fahrenheit to Celsius")) {
               double celcius = Converter.toCelcius(Float.parseFloat(vm.getValue2Convert().toString()));
               Log.i("INFO", String.valueOf(celcius))
                       ;

               //vm.setConverted(String.format("%.2f ºC", celcius));
               vm.setConverted("555");

           }

                /*
            }else if (conversionFactor.equals("Pounds to Kilograms")) {
                double kilo = Converter.toKilogram(Float.parseFloat(convert_input.getText().toString()));
                ctxt.setText(String.format("%.2f kg", kilo));

            }else if(conversionFactor.equals("Quarts to Liters")) {
                double liter = Converter.toLiters(Float.parseFloat(convert_input.getText().toString()));
                ctxt.setText(String.format("%.2f liters", liter));

            }else if (conversionFactor.equals("Inches to Centimeters")) {
                double cm = Converter.toCentimeters(Float.parseFloat(convert_input.getText().toString()));
                ctxt.setText(String.format("%.2f cm", cm));
            }*/

           //     });

       });
    }
}