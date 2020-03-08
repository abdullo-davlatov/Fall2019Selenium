package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select(simpleDropdown);
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("February");
        selectYear.selectByVisibleText("2003");

        // Select all the month one by one
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month: months){
            String monthName =  month.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

//        List<WebElement> days = selectDay.getOptions();
//        for (WebElement day: days){
//            String dayNumber =  day.getText();
//            selectMonth.selectByVisibleText(dayNumber);
//            BrowserUtils.wait(1);
//        }
//
//        List<WebElement> years = selectYear.getOptions();
//        for (WebElement year: years){
//            String yearNumber =  year.getText();
//            selectYear.selectByVisibleText(yearNumber);
//            BrowserUtils.wait(1);
//        }
        BrowserUtils.wait(5);
        Select stateSelect =  new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("New York");

        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equalsIgnoreCase("New York")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        List<WebElement> states = stateSelect.getOptions();
        for (WebElement stateOption: states){
            System.out.println(stateOption.getText());
        }



        BrowserUtils.wait(3);
        driver.quit();
    }


}
