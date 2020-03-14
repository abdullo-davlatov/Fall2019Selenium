package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }


    // Runs only once in the class before @beforemethod and before any test, only once
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }



    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }


    @Test
    public void test1(){
        System.out.println("Test 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1 = 5;
        int num2 = 10;
        Assert.assertTrue(num1 < num2);
    }




}
