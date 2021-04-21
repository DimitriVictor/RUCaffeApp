package com.example.rucaffeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class OrderDonutActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActionBar actionbar;
    private Spinner quantityMenu;
    private TextView textView;
    private TextView subtotalTV;
    private Button addToOrderBtn;

    private String donutType;
    private int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_donut);

        setTitle(R.string.orderdonutname); //FIX STRING
        actionbar = getSupportActionBar();
        String color = getIntent().getStringExtra(getString(R.string.color));
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(color)));

        donutType = getIntent().getStringExtra(getString(R.string.donutType));
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(donutType);

        quantityMenu = (Spinner) findViewById(R.id.quantitiyMenu);
        String[] items = new String[]{"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        quantityMenu.setAdapter(adapter);
        quantityMenu.setOnItemSelectedListener(this);

        subtotalTV = (TextView) findViewById(R.id.subtotalDonutTextView);
        subtotalTV.setText(getString(R.string.subtotal) + Constants.DONUT_PRICE);
        amount = 1;

        addToOrderBtn = (Button) findViewById(R.id.addToOrderBtn);
        addToOrderBtn.setBackgroundColor(Color.parseColor(color));
        addToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToOrder();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        amount = Integer.parseInt(text);
        double cost = Constants.DONUT_PRICE * Integer.parseInt(text);
        DecimalFormat df = new DecimalFormat("#.##");
        String subTotal = df.format(cost);
        subtotalTV.setText((getString(R.string.subtotal) + subTotal));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    public void addToOrder(){
        Donut donut = new Donut(donutType, amount);
        boolean addedSuccessfully = MainActivity.order.add(donut);
        if(addedSuccessfully){
            Toast.makeText(this, R.string.donutsuccess, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, R.string.donutfail, Toast.LENGTH_LONG).show();
        }
    }
}