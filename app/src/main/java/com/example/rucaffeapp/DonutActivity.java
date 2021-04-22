package com.example.rucaffeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * This class handles the operations for selecting a donut to order. The user is presented with the different  types of donut flavors to select
 */
public class DonutActivity extends AppCompatActivity {

    private ActionBar actionbar;
    private ImageView donutMenuPic;
    private Button jellyBtn;
    private Button bostonBtn;
    private Button glazedBtn;
    private Button blueberryBtn;
    private Button oldfashionBtn;
    private Button spicyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);

        setTitle(R.string.donutname);
        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        //Initialize Buttons
        donutMenuPic = (ImageView) findViewById(R.id.donutMenuPic);
        jellyBtn = (Button) findViewById(R.id.jellyBtn);
        bostonBtn = (Button) findViewById(R.id.bostonBtn);
        glazedBtn = (Button) findViewById(R.id.glazedBtn);
        blueberryBtn = (Button) findViewById(R.id.blueberryBtn);
        oldfashionBtn = (Button) findViewById(R.id.oldfashionBtn);
        spicyBtn = (Button) findViewById(R.id.spicyBtn);

        //Handle onclicks for buttons
        jellyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDonut(getString(R.string.jellyDonut), getString(R.string.jellyred));
            }
        });
        jellyBtn.setBackgroundColor(getResources().getColor(R.color.jellyRed));

        bostonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDonut(getString(R.string.bostonCream), getString(R.string.brown));
            }
        });
        bostonBtn.setBackgroundColor(getResources().getColor(R.color.brown));

        glazedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDonut(getString(R.string.glazed), getString(R.string.lightbrown));
            }
        });
        glazedBtn.setBackgroundColor(getResources().getColor(R.color.lightbrown));

        blueberryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDonut(getString(R.string.blueberries), getString(R.string.blueberry));
            }
        });
        blueberryBtn.setBackgroundColor(getResources().getColor(R.color.blueberry));

        oldfashionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDonut(getString(R.string.oldfashion), getString(R.string.oldfashioncolor));
            }
        });
        oldfashionBtn.setBackgroundColor(getResources().getColor(R.color.oldfashioncolor));

        spicyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDonut(getString(R.string.spicy), getString(R.string.spicycolor));
            }
        });
        spicyBtn.setBackgroundColor(getResources().getColor(R.color.spicycolor));
    }

    /**
     * This function takes the user to the page where they can order the donut they clicked
     * @param s the donut type that the user clicked
     * @param color the color corresponding to the donut type
     */
    private void orderDonut(String s, String color) {
        Intent intent = new Intent(this, OrderDonutActivity.class);
        intent.putExtra(getString(R.string.donutType), s);
        intent.putExtra(getString(R.string.color), color);
        startActivity(intent);
    }
}