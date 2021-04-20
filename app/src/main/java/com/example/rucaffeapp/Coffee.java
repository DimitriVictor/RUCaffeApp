package com.example.rucaffeapp;

import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;

public class Coffee extends MenuItem implements Customizable {

    private boolean hasCream = false;
    private boolean hasSyrup = false;
    private boolean hasWhippedCream = false;
    private boolean hasMilk = false;
    private boolean hasCaramel = false;

    private String size;
    private int count;
    private double price;


    /**
     * Constructor for the Coffee class. It initialized the size, count, and price
     */
    public Coffee(){
        size = getString(R.string.NoSize);
        count = 1;
        price = 0;
    }

    /**
     * This function adds an Addin to the coffee order
     * @param obj to be added
     * @return returns true whether  the add was sucessful and false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof String) {
            String additionType = (String) obj;
            if (additionType.equals(getString(R.string.Cream))) {
                hasCream = true;
                return true;
            } else if (additionType.equals(getString(R.string.Cream))) {
                hasWhippedCream = true;
                return true;
            } else if (additionType.equals(getString(R.string.Milk))) {
                hasMilk = true;
                return true;
            } else if (additionType.equals(getString(R.string.Syrup))) {
                hasSyrup = true;
                return true;
            } else if (additionType.equals(getString(R.string.Caramel))) {
                hasCaramel = true;
                return true;
            }
        }
        return false;
    }

    /**
     * This function removes an Addin from the coffee order
     * @param obj to be removed
     * @return return true if the obj was removed and false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof String){
            String additionType = (String)obj;
            if(additionType.equals(getString(R.string.Cream))){
                hasCream = false;
                return true;
            }else if(additionType.equals(getString(R.string.WhippedCream))){
                hasWhippedCream = false;
                return true;
            }else if(additionType.equals(getString(R.string.Milk))){
                hasMilk = false;
                return true;
            }else if(additionType.equals(getString(R.string.Syrup))){
                hasSyrup = false;
                return true;
            }else if(additionType.equals(getString(R.string.Caramel))) {
                hasCaramel = false;
                return true;
            }
        }
        return false;
    }

    /**
     * This functions creates and returns the string representation of a coffee
     * @return the string representation of a Coffee ordered
     */
    @Override
    public String toString(){
        boolean hasToppings = false;
       System.out.println(Resources.getSystem().getString(R.string.Coffee));
        String order = "";

        order += "(" + Integer.toString((int)count) + ") ";

        order += size +"[";

        if(hasCream == true){
            order += getString(R.string.Cream) + ", ";
            hasToppings = true;
        }
        if(hasSyrup == true){
            order += getString(R.string.Syrup) + ", ";
            hasToppings = true;
        }
        if(hasWhippedCream == true){
            order += getString(R.string.WhippedCream) + ", ";
            hasToppings = true;

        }
        if(hasMilk == true){
            order += getString(R.string.Milk) + ", ";
            hasToppings = true;
        }
        if(hasCaramel == true){
            order += getString(R.string.Caramel) + ", ";
            hasToppings = true;
        }
        if(hasToppings == true){
            order = order.substring(0,order.length()-2);
        }

        order += "]";

        return order;
    }

    /**
     * The function will return the price of the coffee created
     * @return coffee price
     */
    @Override
    double itemPrice() {
        return price;
    }
}
