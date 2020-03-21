package com.automation.tests.WarmUp;

import java.util.*;

public class CollectionOfficeHour {


    public static void main(String[] args) {

//        String price = "100.99";
//        double priceNum  =Double.parseDouble(price);
//        System.out.println("price = " + price);



        List<String> priceLstStr = new ArrayList<>(Arrays.asList("99.99", "149.99", "79.99", "149.99", "299.99", "599.99" ));
        priceLstStr.add("999.99");
        System.out.println("priceLstStr = " + priceLstStr);

        // but we want to get List<Double>
        List<Double> prices = new ArrayList<>();
        for (String eachPrice : priceLstStr) {
            prices.add(Double.parseDouble(eachPrice));
        }
        System.out.println("prices in double = " + prices);


        // how do i get max price, min, average


        // remove items above average


        // get the unique prices
        Set<Double> uniquePrices = new HashSet<>( prices );
        System.out.println("uniquePrices = " + uniquePrices);


    }
    
}
