package com.automation.homework;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class YearsMonthDays {

    private WebDriver driver = Driver.getDriver();

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select year = new Select(driver.findElement(By.id("year")));

    }


}
