package com.example.rucaffeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;

import java.security.cert.Certificate;

public class CoffeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Coffee coffee = new Coffee();

    private double sizePrice = 0;
    private double count = 1;
    private double addInsPrice = 0;

    private Button addOrderButton;
    private CheckBox caramelCheckbox;
    private CheckBox whippedCreamCheckbox;
    private CheckBox creamCheckbox;
    private CheckBox syrupCheckbox;
    private CheckBox milkCheckbox;
    private TextView totalTextArea;
    private Spinner sizeSpinner;
    private Spinner countSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        addOrderButton = (Button) findViewById(R.id.addToOrderButton);
        caramelCheckbox = (CheckBox) findViewById(R.id.caramelCheckBox);
        milkCheckbox = (CheckBox) findViewById(R.id.milkCheckBox);
        creamCheckbox = (CheckBox) findViewById(R.id.creamCheckBox);
        whippedCreamCheckbox = (CheckBox) findViewById(R.id.whippedCreamCheckBox);
        syrupCheckbox = (CheckBox) findViewById(R.id.syrupCheckBox);
        sizeSpinner = (Spinner) findViewById(R.id.sizeSpinner);
        countSpinner = (Spinner) findViewById(R.id.countSpinner);
        totalTextArea = (TextView) findViewById(R.id.subtotalTextView);

        String[] nums = new String[]{"1", "2", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, nums);
        countSpinner.setAdapter(adapter);
        countSpinner.setOnItemSelectedListener(this);

        String[] sizes = new String[]{getString(R.string.Short), getString(R.string.Tall), getString(R.string.Grande), getString(R.string.Venti)};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sizes);
        sizeSpinner.setAdapter(adapter1);
        sizeSpinner.setOnItemSelectedListener(this);

        creamCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectCream(view);
            }
        });

        milkCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectMilk(view);
            }
        });

        whippedCreamCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectWhippedCream(view);
            }
        });

        caramelCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectCaramel(view);
            }
        });

        syrupCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectSyrup(view);
            }
        });

        addOrderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addOrderSelected(view);
            }
        });

    }


    public void selectCream(View view) {
        String type = getString(R.string.Cream);
        if (creamCheckbox.isChecked()) {
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        } else {
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice) * count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }

    public void selectMilk(View view) {
        String type = getString(R.string.Milk);
        if (milkCheckbox.isChecked()) {
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        } else {
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice) * count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }

    public void selectWhippedCream(View view) {
        String type = getString(R.string.WhippedCream);
        if (whippedCreamCheckbox.isChecked()) {
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        } else {
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice) * count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }

    public void selectSyrup(View view) {
        String type = getString(R.string.Syrup);
        if (syrupCheckbox.isChecked()) {
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        } else {
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice) * count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }

    public void selectCaramel(View view) {
        String type = getString(R.string.Caramel);
        if (caramelCheckbox.isChecked()) {
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        } else {
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice) * count;
        totalTextArea.setText("$" + String.format("%.2f", totalPrice));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getAdapter() == sizeSpinner.getAdapter()) {
            String selected = parent.getItemAtPosition(position).toString();
            if (selected.equals(Constants.SHORT)) {
                sizePrice = Constants.SHORT_PRICE;
                coffee.setSize(Constants.SHORT);
            } else if (selected.equals(Constants.TALL)) {
                sizePrice = Constants.TALL_PRICE;
                coffee.setSize(Constants.TALL);
            } else if (selected.equals(Constants.GRANDE)) {
                sizePrice = Constants.GRANDE_PRICE;
                coffee.setSize(Constants.GRANDE);
            } else {
                sizePrice = Constants.VENTE_PRICE;
                coffee.setSize(Constants.VENTE);
            }
            double totalPrice = (sizePrice + addInsPrice) * count;
            totalTextArea.setText("$" + String.format("%.2f", totalPrice));
        }


        if (parent.getAdapter() == countSpinner.getAdapter()) {

            String text = parent.getItemAtPosition(position).toString();
            count = (double) Integer.parseInt(text);
            coffee.setCount((int) count);
            double totalPrice = (sizePrice + addInsPrice) * count;
            totalTextArea.setText("$" + String.format("%.2f", totalPrice));
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addOrderSelected(View view){

        double totalPrice = (sizePrice + addInsPrice)*count;
        coffee.setPrice(totalPrice);
        boolean addedSuccessfully = MainActivity.order.add(coffee);
        if(addedSuccessfully){
            System.out.println("asdfasd");
            Toast.makeText(this, R.string.coffeeSuccess, Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, R.string.coffeeFail, Toast.LENGTH_LONG).show();
        }
    }

}