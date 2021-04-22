package com.example.rucaffeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ViewOrder extends AppCompatActivity {

    private ActionBar actionbar;

    private TextView subtotalTextView;
    private TextView salestaxTextView;
    private TextView totalTextView;
    private Button placeOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        setTitle(R.string.viewordername);
        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        subtotalTextView = (TextView) findViewById(R.id.subtotalOrderTextView);
        subtotalTextView.setText(getString(R.string.subtotal) + Constants.ZERO);

        salestaxTextView = (TextView) findViewById(R.id.salestaxTextView);
        salestaxTextView.setText(getString(R.string.salestax) + Constants.ZERO);

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(getString(R.string.total) + Constants.ZERO);
    }
}