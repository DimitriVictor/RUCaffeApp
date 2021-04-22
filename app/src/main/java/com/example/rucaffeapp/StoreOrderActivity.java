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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        remove(position);
    }
//need to create in string.xml
    private String createString(ArrayList<String> specific_order_list, int orderNum){
        String result = "Order# " + orderNum + " ";
        for(int i = 0; i< specific_order_list.size(); i++){
            result += specific_order_list.get(i) + " ";
        }
        return result;
    }

    private ArrayList<String> get_string_orders(){

        ArrayList<String> store_orders = new ArrayList<>();
        ArrayList<Integer> all_order_nums = MainActivity.storeOrder.getNumList();

        for(int i = 0; i< all_order_nums.size(); i++){

            int order_index = all_order_nums.get(i);
            ArrayList<String> specific_order_list = MainActivity.storeOrder.getOrder(i).getOrderList();
            store_orders.add(createString(specific_order_list, order_index));

        }
        return  store_orders;
    }

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

    public void updateListView(){

    }

    public void showToast(){
        Toast.makeText(this, R.string.orderRemoved, Toast.LENGTH_LONG).show();
    }

}