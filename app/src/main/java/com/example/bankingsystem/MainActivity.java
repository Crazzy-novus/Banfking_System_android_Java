package com.example.bankingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.viewcustomers_bt);

        bt.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,User_List.class);
            startActivity(intent);
            finish();

        });
    }
}