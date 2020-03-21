package com.automation.tests.WarmUp;

import java.util.HashMap;
import java.util.Map;

public class MapPracticeOfficeHour {

    public static void main(String[] args) {

        // Take home task: create a Map of ProductName, Price --
        // using selenium to get all the data
        // and store it onto your Map

        // Also try to create Map of Product name and name length

        //List<Map<String, Double> > to store Each name price pair(just for the )

        // how do you iterate over a Map
        // Is a Map Iterable(does Map interface extend Iterable, Collection interface) : NO!!!!!!!!!
        // anything not iterable we can not use foreach loop

        Map<String, String> nameStatePair = new HashMap<>(); // LinkedHashMap for keeping insertion order
        nameStatePair.put("Faith", "Fl");
        nameStatePair.put("Vlad", "SC");
        nameStatePair.put("Hasan", "NY");
        nameStatePair.put("Abdullo", "NY");
        nameStatePair.put("Atakan", "GA");

        System.out.println("nameStatePair = " + nameStatePair);
        
        
        
    }
    
    
    
}
