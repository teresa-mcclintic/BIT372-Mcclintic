package com.example.modelbinding;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.modelbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        User user = new User("John", "john.doe@outlook.com");

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setUser(user);

        Button btn = findViewById(R.id.next_btn);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(this, FruitActivity.class));
        });
    }
}
