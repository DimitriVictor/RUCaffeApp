package com.example.rucaffeapp;

import java.text.DecimalFormat;

public class Constants {

    //CONSTANTS FOR PRICING
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static final String ZERO = df.format(0.0);
    public static final double SALES_TAX = .06625;

    //CONSTANTS FOR DONUT OBJECT
    public static final double DONUT_PRICE = 1.39;

    //CONSTANTS FOR COFFEE ADDINS
    public static final String CREAM = "Cream";
    public static final String SYRUP = "Syrup";
    public static final String MILK = "Milk";
    public static final String WHIPPEDCREAM = "WhippedCream";
    public static final String CARAMEL = "Caramel";

    public static final double ADDIN_PRICE = .20;

    //CONSTANTS FOR COFFEE SIZES
   // public static final String SHORT = "Short";
    public static final double SHORT_PRICE = 1.99;
   // public static final String TALL = "Tall";
    public static final double TALL_PRICE = 2.49;
   // public static final String GRANDE = "Grande";
    public static final double GRANDE_PRICE = 2.99;
   // public static final String VENTE = "Venti";
    public static final double VENTE_PRICE = 3.49;


    //CONSTANTS FOR # OF COFFEES
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;

    public static final int NO_ORDERS = 0;

    //CONSTANTS FOR STORE ORDER
  //  public static final String zeroDollars = "$0.00";
}
