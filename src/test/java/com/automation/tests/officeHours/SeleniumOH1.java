package com.automation.tests.officeHours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {
    public static void main(String[] args) {

        // Create arraylist of Strings - iterate over it
        ArrayList<String>keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator <String>iterator=keysToSearch.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Iterator <String> iterator1=keysToSearch.iterator();
        while(iterator1.hasNext()){
            String item=iterator1.next();
            System.out.println(item);
            System.out.println("*" +item);
        }

        //
        HashMap<String, String> personalInfo = new HashMap<>();
        personalInfo.put("name", "Bryan");
        personalInfo.put("student_ID", "23146365541");
        personalInfo.put("major", "computer science");

        Iterator<String> mapIterator = personalInfo.keySet().iterator();
        while (mapIterator.hasNext()){
            String key = mapIterator.next();
            System.out.println(mapIterator.next() + ":" + personalInfo.get(key));
        }



    }
}
