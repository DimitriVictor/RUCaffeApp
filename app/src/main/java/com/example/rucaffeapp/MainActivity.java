package com.example.rucaffeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


/**
 * This class is the Main Activity where the user can order a donut, order a coffee, view their order, and view all of the store orders they have made
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class MainActivity extends AppCompatActivity {

    public static Order order;
    public static StoreOrder storeOrder = new StoreOrder();
    public static int orderNum = 1;
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
        actionbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

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

        viewOrderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openOrderMenu();
            }
        });

        storeOrderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openViewStoreOrder();
            }
        });
    }

    /**
     * This function takes the user to the screen where they can order donuts
     */
    public void openDonutMenu(){
        createNewOrder();
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }

    /**
     * This function takes the user to the screen where they can order coffee
     */
    public void openCoffeeMenu(){
        createNewOrder();
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivity(intent);
    }

    /**
     * This function takes the user to the screen where they can view all the items in their current order
     */
    private void openOrderMenu() {
        createNewOrder();
        Intent intent = new Intent(this, ViewOrderActivity.class);
        startActivity(intent);
    }

    /**
     * This function takes the user to the screen where they can view all the orders they have made
     */
    private void openViewStoreOrder(){
        //do i need to create an order
        Intent intent = new Intent(this, StoreOrderActivity.class);
        startActivity(intent);
    }

    /**
     * This function creates a new order if one does not already exist each time
     */
    private void createNewOrder() {
        if (!this.orderExist) {
            this.order = new Order(this.orderNum);
            this.orderNum++;
            this.orderExist = true;
        }
    }

}