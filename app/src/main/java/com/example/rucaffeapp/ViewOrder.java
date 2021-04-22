package com.example.rucaffeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ViewOrder extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ActionBar actionbar;

    private TextView subtotalTextView;
    private TextView salestaxTextView;
    private TextView totalTextView;
    private ListView ordersListView;
    private Button placeOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        setTitle(R.string.viewordername);
        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        subtotalTextView = (TextView) findViewById(R.id.subtotalOrderTextView);
        //subtotalTextView.setText(getString(R.string.subtotal) + Constants.ZERO);

        salestaxTextView = (TextView) findViewById(R.id.salestaxTextView);
        //salestaxTextView.setText(getString(R.string.salestax) + Constants.ZERO);

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        //totalTextView.setText(getString(R.string.total) + Constants.ZERO);

        ordersListView = (ListView) findViewById(R.id.ordersListView);
        ordersListView.setOnItemClickListener(this);

        orderList = MainActivity.order.getOrderList();
        list_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, orderList);

        ordersListView.setAdapter(list_adapter);

        placeOrderBtn = (Button) findViewById(R.id.placeOrderBtn);
        placeOrderBtn.setBackgroundColor(getResources().getColor(R.color.black));



        updatePrices();
    }

    /**
     * This function generates the values for subtotal, tax, and total price in a properly formatted manner
     */
    private void updatePrices() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(2);

        double subTotal = MainActivity.order.getSubTotal();
        double tax = Constants.SALES_TAX * subTotal;
        double total = subTotal + tax;

        String formattedSubTotal = df.format(subTotal);
        String formattedTax = df.format(tax);
        String formattedTotal = df.format(total);

        subtotalTextView.setText(getString(R.string.subtotal) + formattedSubTotal);
        salestaxTextView.setText(getString(R.string.salestax) + formattedTax);
        totalTextView.setText(getString(R.string.total) + formattedTotal);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){

    }




}