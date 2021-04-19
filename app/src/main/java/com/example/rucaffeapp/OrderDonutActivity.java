package com.example.rucaffeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class OrderDonutActivity extends AppCompatActivity {

    private ActionBar actionbar;
    private Spinner quantityMenu;
    private TextView textView;
    private String donutType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_donut);

        setTitle("Add To Order"); //FIX STRING
        actionbar = getSupportActionBar();
        String color = getIntent().getStringExtra(getString(R.string.color));
        //System.out.println(color);
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(color)));

        donutType = getIntent().getStringExtra(getString(R.string.donutType));
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(donutType);

        quantityMenu = (Spinner) findViewById(R.id.quantitiyMenu);
        String[] items = new String[]{"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        quantityMenu.setAdapter(adapter);
    }
}