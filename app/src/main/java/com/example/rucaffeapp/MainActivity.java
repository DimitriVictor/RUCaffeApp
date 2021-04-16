package com.example.rucaffeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * This class is the Main Activity
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
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

        orderDonutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openDonutMenu();
            }
        });

        orderCoffeeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openCoffeeMenu();
            }
        });
    }

    public void openDonutMenu(){
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }

    public void openCoffeeMenu(){
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivity(intent);
    }
}