package com.automation.tests.WarmUp;

public class ReverseString {


    public static void main(String[] args) {
        oddNumber(10, 20);
        reverseString("salom");


        String name = "Abdullo";
        String reversedName = "";
        for (int i = name.length()-1; i >= 0; i--) {
            reversedName = reversedName + name.charAt(i);
        }
        System.out.println("reversedName = " + reversedName);

    }

    public static void oddNumber(int start, int end){

        for (int i = start; i < end ; i++) {

            if (i % 2 == 1){
                System.out.println("i = " + i);
            }
        }
    }

    public static void reverseString(String name){

        String reversed = "";
        for (int i = name.length()-1; i >= 0 ; i--) {
            reversed = reversed + name.charAt(i);
        }
        System.out.println("reversed = " + reversed);
    }

}
