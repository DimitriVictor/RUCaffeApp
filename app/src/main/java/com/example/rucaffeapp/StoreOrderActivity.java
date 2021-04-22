package com.example.rucaffeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * This class handles the operations for the store order.
 * @author Pamdank Ambadipudi
 * @author Dimitri Victor
 */
public class StoreOrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayAdapter<String> list_adapter;
    ArrayList<String> store_orders;
    private ActionBar actionbar;

    private ListView storeOrdersListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);

        setTitle(R.string.storeorder);
        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        storeOrdersListView = (ListView) findViewById(R.id.storeOrderListView);
        storeOrdersListView.setOnItemClickListener(this);

         store_orders = get_string_orders();

        list_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, store_orders);
        storeOrdersListView.setAdapter(list_adapter);

    }

    /**
     * This function is called when an order is clicked
     * @param parent the AdapterView where the click happened.
     * @param view the view within the AdapterView that was clicked (this will be a view provided by the adapter)
     * @param position the position of the view in the adapter
     * @param id row id of the item that was clicked
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        remove(position);
    }

    /**
     * This function creates the string for each order
     * @param specific_order_list the list of menuItems in the given order
     * @param orderNum this is the specific order's number
     * @return returns the string order representation
     */
    private String createString(ArrayList<String> specific_order_list, int orderNum){
        String result = getString(R.string.orderNum) + orderNum + ": ";
        for(int i = 0; i< specific_order_list.size(); i++){
            result += specific_order_list.get(i) + ", ";
        }
        return result;
    }

    /**
     * This function returns the ArrayList of strings to be displayed on the listView
     * @return an ArrayList of strings
     */
    private ArrayList<String> get_string_orders(){

        ArrayList<String> store_orders = new ArrayList<>();
        ArrayList<Integer> all_order_nums = MainActivity.storeOrder.getNumList();

        for(int i = 0; i< all_order_nums.size(); i++){

            int order_index = all_order_nums.get(i);
            ArrayList<String> specific_order_list = MainActivity.storeOrder.getOrder(i).getOrderList();
            store_orders.add(createString(specific_order_list, order_index));
        }
        return store_orders;
    }

    /**
     * This function is called when the user clicks an order to see if they want to delete an order
     * @param position is the indexed position of the selected item in the ListView
     */
    public void remove(int position){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(R.string.deleteThisMessage).setTitle(R.string.confirmation);
        alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.storeOrder.remove(MainActivity.storeOrder.getOrder(position));
                store_orders.remove(position);
                showToast();
                list_adapter.notifyDataSetChanged();
            }
        });
        alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();

    }

    /**
     * This function is called to show a toast when an order is removed
     */
    public void showToast(){
        Toast.makeText(this, R.string.orderRemoved, Toast.LENGTH_LONG).show();
    }

}