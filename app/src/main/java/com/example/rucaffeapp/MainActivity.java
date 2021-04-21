package com.example.rucaffeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.lang.ref.Reference;


/**
 * This class is the Main Activity
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class MainActivity extends AppCompatActivity {
    public static Reference references;


    public static Order order;
    public static StoreOrder storeOrder = new StoreOrder();
    private int orderNum = 1;
    public static boolean orderExist = false;

    private ActionBar actionbar;
    private ImageButton orderDonutButton;
    private ImageButton orderCoffeeButton;
    private ImageButton viewOrderButton;
    private ImageButton storeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

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
        createNewOrder();
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }

    public void openCoffeeMenu(){
        createNewOrder();
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivity(intent);
    }

    /**
     * This function creates a new order if one does not already exist each time
     */
    private void createNewOrder() {
        if(!this.orderExist){
            this.order = new Order(this.orderNum);
            this.orderNum++;
            this.orderExist = true;
        }
    }

}