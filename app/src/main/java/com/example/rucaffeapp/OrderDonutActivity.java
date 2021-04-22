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

/**
 * This class handles the operations for ordering the selected donut. The user can select the amount of donut to order as well
 * @author Pamdank Ambadipudi
 * @author Dimitri Victor
 */
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
        String[] items = new String[]{String.valueOf(Constants.ONE), String.valueOf(Constants.TWO), String.valueOf(Constants.THREE), String.valueOf(Constants.FOUR), String.valueOf(Constants.FIVE)};
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

    /**
     * This function adjusts the displayed prices based on what item in the drop down menu was selected
     * @param parent the AdapterView where the click happened.
     * @param view the view within the AdapterView that was clicked (this will be a view provided by the adapter)
     * @param position the position of the view in the adapter
     * @param id row id of the item that was clicked
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        amount = Integer.parseInt(text);
        double cost = Constants.DONUT_PRICE * Integer.parseInt(text);
        DecimalFormat df = new DecimalFormat("#.##");
        String subTotal = df.format(cost);
        subtotalTV.setText((getString(R.string.subtotal) + subTotal));
    }

    /**
     * This function handles the logic that occurs when no item is selected
     * @param parent the AdapterView where the click happened
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    /**
     * This function adds the donut with the specified quantity to the list of items in the order
     */
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