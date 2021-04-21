package com.example.rucaffeapp;

/**
 * This is the class that represents the donut object. It contains different fields relating to the type, flavor, and quantity of donuts.
 * @author Padmank Ambadipudi
 * @author Dimitri Vitcor
 */
public class Donut extends MenuItem {
    private String donutType;
    private int quantity;

    /**
     * Constructor for the Donut object
     * @param donutType the type of donut
     * @param quantity the amount of specific donut
     */
    public Donut(String donutType, int quantity){
        this.donutType = donutType;
        this.quantity = quantity;
    }

    /**
     * This function calculates the price for one single donut based on the donut type
     * @return donut price
     */
    @Override
    double itemPrice() {
        double price = 0.0;
        price = this.quantity * Constants.DONUT_PRICE;
        return price;
    }

    /**
     * Getter method for the donut type
     * @return the type of donut
     */
    public String getDonutType(){
        return this.donutType;
    }

    /**
     * Getter method for the amount a certain donut
     * @return the amount of a donut
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Setter method to set the quantity of a donut
     * @param n the number of donuts
     */
    public void setQuantity(int n) {
        this.quantity = n;
    }

    /**
     * This function provides a String representation of the Donut object
     * @return string representation of donut
     */
    @Override
    public String toString(){
        return this.getDonutType() + ": " + "(" + this.getQuantity() + ")";
    }
}
