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

/**
 * This class handles the operations for viewing the current items in the cart to be ordered. The user can delete items or place the order
 * @author Pamdank Ambadipudi
 * @author Dimitri Victor
 */
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
        salestaxTextView = (TextView) findViewById(R.id.salestaxTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);

        ordersListView = (ListView) findViewById(R.id.ordersListView);
        ordersListView.setOnItemClickListener(this);
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.order.getOrderList());
        ordersListView.setAdapter(list);

        placeOrderBtn = (Button) findViewById(R.id.placeOrderBtn);
        placeOrderBtn.setBackgroundColor(getResources().getColor(R.color.black));
        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeOrder();
            }
        });

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

    /**
     * This function handles the logic that occurs when an item in the list of items to be ordered is clicked on by the user
     * @param parent the AdapterView where the click happened.
     * @param view the view within the AdapterView that was clicked (this will be a view provided by the adapter)
     * @param position the position of the view in the adapter
     * @param id row id of the item that was clicked
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(R.string.deleteMessege).setTitle(R.string.deleteTitle);
        alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                removeOrder(position);
            }
        });
        alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                displayToast(getString(R.string.itemno));
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }


    /**
     * Removes an item from the list orders and updates the display accordingly
     * @param position in list of orders that needs to be removed
     */
    private void removeOrder(int position) {
        boolean isRemoved = MainActivity.order.remove(MainActivity.order.getItem(position));
        if(!isRemoved){
            displayToast(getString(R.string.itemfailed));
            return;
        }
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.order.getOrderList());
        ordersListView.setAdapter(list);
        updatePrices();
        displayToast(getString(R.string.itemremoved));
    }

    /**
     * Displays a toast message to the user
     * @param s message to be displayed
     */
    private void displayToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    /**
     * This function responds to the user's press of the Place Order button and places the order
     */
    private void placeOrder() {
        if(ordersListView.getAdapter().getCount() == Constants.ZERO){
            displayToast(getString(R.string.cantplace));
            return;
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(R.string.placeMessege).setTitle(R.string.placeTitle);
        alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                addOrder();
            }
        });
        alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                displayToast(getString(R.string.itemno));
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    /**
     * This function places the order by adding it to the list of store orders and then updates the screen accordingly
     */
    private void addOrder() {
        boolean addedSuccessfully = MainActivity.storeOrder.add(MainActivity.order);
        if(!addedSuccessfully){
            displayToast(getString(R.string.placeFailed));
            return;
        }

        MainActivity.orderExist = false;
     //   for(int i = 0; i < MainActivity.order.getOrderLength(); i++){
      //      MainActivity.order.remove(MainActivity.order.getItem(i));
       // }
      //  ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.order.getOrderList());
       // ordersListView.setAdapter(list);
      //  updatePrices();
        displayToast(getString(R.string.orderadded));
        ViewOrder.super.onBackPressed();

    }
}