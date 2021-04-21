package com.example.rucaffeapp;

import java.util.ArrayList;

/**
 * This class keeps the list of orders placed by the user and implements the Customizable interface
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class StoreOrder implements Customizable{
     private ArrayList<Order> storeOrders;

    /**
     * This function is the constructor for the class
     */
    public StoreOrder(){
         storeOrders = new ArrayList<>();
     }

    /**
     * This function adds an order to the list of store orders
     * @param obj to be added
     * @return true if the order was added successfully, false if it was not
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            Order order = (Order)obj;
            this.storeOrders.add(order);
            return true;
        }
        return false;
    }

    /**
     * This function removes an order to the list of store orders
     * @param obj to be added
     * @return true if the order was removed successfully, false if it was not
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order){
            Order order = (Order)obj;
            this.storeOrders.remove(order);
            return true;
        }
        return false;
    }

    /**
     * This function gets the number of orders currently in the store order list
     * @return length of the store order list
     */
    public int getNumOrders(){
       return storeOrders.size();
    }

    /**
     * This function gets a list of order numbers in the store order list
     * @return list containing all the order numbers
     */
    public ArrayList<Integer> getNumList(){
         ArrayList<Integer> list = new ArrayList<>();
         for(int i = 0; i < storeOrders.size(); i++){
             list.add(storeOrders.get(i).getOrderNumber());
         }
         return list;
    }

    /**
     * This function gets an order based on a specified location in the list
     * @param index where the order is located in the list
     * @return the specified order
     */
    public Order getOrder(int index){
        return storeOrders.get(index);
    }

    /**
     * This function gets the total amount of money that all the orders placed cost
     * @return price of all orders in store orders
     */
    public Double getStoreTotal(){
         Double total = 0.0;
         for(int i = 0; i<storeOrders.size(); i++){
             total += storeOrders.get(i).getSubTotal();
         }
         return total;
    }


}
