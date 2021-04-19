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

        setTitle("Order Donuts");
        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000"))); //MIGHT NEED TO CHANGE

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
    }

    private void orderDonut(String s, String color) {
        Intent intent = new Intent(this, OrderDonutActivity.class);
        intent.putExtra(getString(R.string.donutType), s);
        intent.putExtra(getString(R.string.color), color);
        startActivity(intent);
    }
}