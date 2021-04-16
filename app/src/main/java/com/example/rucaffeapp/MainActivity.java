package com.example.rucaffeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton orderDonutButton;
    private ImageButton orderCoffeeButton;
    private ImageButton viewOrderButton;
    private ImageButton storeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderDonutButton = (ImageButton) findViewById(R.id.openDonutButton);
        orderCoffeeButton = (ImageButton) findViewById(R.id.openCoffeeButton);
        viewOrderButton = (ImageButton) findViewById(R.id.viewOrderButton);
        storeOrderButton = (ImageButton) findViewById(R.id.storeOrderButton);
    }
}