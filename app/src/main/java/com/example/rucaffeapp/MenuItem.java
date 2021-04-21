package com.example.rucaffeapp;

import androidx.appcompat.app.AppCompatActivity;

abstract class MenuItem extends AppCompatActivity {
    /**
     * This function generates the price of an ordered items
     * @return price of the item
     */
    abstract double itemPrice();
}
