package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {
//        System.out.println(reverseString("apple"));
        // Unit test
        // to check if our method
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        // Assertion
        verifyEquals(expected, actual);
    }

    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elppa";
        String actual = reverseString("apple");
        // to verify if expected result is equals to actual
        Assert.assertEquals(actual, expected);

    }

    @Test(description = "Verify if method can reverse a string")
    public void test2(){
        String expected = "rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual, expected);


    }



    public static boolean verifyEquals(String expected, String actual){
        if (expected.equals(actual)){
            System.out.println("Test Passed");
            return true;
        } else {
            System.out.println("Test Failed");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
            return false;
        }
    }



    public static String reverseString(String str){
        String reversed = "";
        for (int i = str.length()-1; i >= 0 ; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

}
