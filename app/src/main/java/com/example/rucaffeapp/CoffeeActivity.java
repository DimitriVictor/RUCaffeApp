package com.example.rucaffeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import android.widget.TextView;

import java.security.cert.Certificate;

public class CoffeeActivity extends AppCompatActivity {

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
        totalTextArea =  (TextView) findViewById(R.id.subtotalTextView);

        totalTextArea.setText(R.string.Cream);
        caramelCheckbox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               // selectCaramel();
            }
        });

        milkCheckbox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
          //      selectMilk();
            }
        });

        creamCheckbox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectCream();
            }
        });

        whippedCreamCheckbox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
          //      selectWhippedCream();
            }
        });

        caramelCheckbox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
          //      selectCaramel();
            }
        });

        System.out.println(Resources.getSystem().getString(R.string.Coffee));

    }

    /**
     * This function displays whether the cream addin was selected or deselected.
     */
    void selectCream() {
        String type = "Constants.CREAM";
        if(creamCheckbox.isSelected()){
            addInsPrice += Constants.ADDIN_PRICE;
            coffee.add(type);
        }else{
            addInsPrice -= Constants.ADDIN_PRICE;
            coffee.remove(type);
        }
        double totalPrice = (sizePrice + addInsPrice)*count;
        totalTextArea.setText("$" + String.format("%.2f",totalPrice));
    }
}