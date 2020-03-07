package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsTest {

    public static void main(String[] args) {

//        WebDriverManager.chromedriver().version("79").setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));

        if (blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("CLick on black button");
            blackButton.click();
        } else {
            System.out.println("Failed to click on black button");
        }

        BrowserUtils.wait(2);

        if (blackButton.isSelected()){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }


        driver.quit();
    }

}
