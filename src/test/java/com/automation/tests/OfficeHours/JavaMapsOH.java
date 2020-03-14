package com.automation.tests.OfficeHours;

import java.util.*;

public class JavaMapsOH {


    public static void main(String[] args) {


        HashMap<String, String> user1 = new HashMap<>();
        user1.put("First Name", null);
        user1.put("Last Name", "Smith");
        user1.put("Account Number", "A6345165");
        user1.put("DOB", "02.20.1980");

        System.out.println(user1);


        LinkedHashMap<String, String> user2 = new LinkedHashMap<>();
        user2.put("First Name", "John");
        user2.put("Last Name", null);
        user2.put("Last Name", "White");
        user2.put("Last Name", "Green");
        user2.put("Account Number", "A50564");
        user2.put("DOB", "12.02.1964");

        System.out.println(user2);

        HashMap<String, String> user3 = new HashMap<>(user1);
        user3.put("Account Number", "A50564431");
        user3.put("DOB", "12.08.1990");

        List<HashMap<String, String>> users = new ArrayList<>();
        //
        users.add(user1);
        users.add(user2);
        users.add(user3);


        System.out.println("=========LIST==========\n" + users);
        for (HashMap<String, String> user : users){
            System.out.println("Account Number: " + user.get("Account Number")
                    + " | Last Name: " + user.get("Last Name"));
        }

        int i = 1;
        for (HashMap<String, String> user : users){
            System.out.println("User " + i);

            Iterator<String> keys = user.keySet().iterator();
            while (keys.hasNext()){
                String key = keys.next();
                System.out.println(key + ": " + user.get(key));
            }
            i++;

        }


    }

}
