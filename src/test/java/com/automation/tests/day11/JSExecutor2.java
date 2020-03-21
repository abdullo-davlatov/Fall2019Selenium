package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }


    @Test
    public void clickTest() {
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
//        disable this click action ,to perform it with js executor
//        link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //after "" you can list webelements that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //arguments - listed after ,
        //use index to get specific webelement
        // WebElement arguments = {element, link, link2};
        //from left - to right
        js.executeScript("arguments[0].click()", link);
        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);
        BrowserUtils.wait(2);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "Now it's gone!");
    }

    @Test
    public void testInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // to get text from input box - read attribute "value"
        // to enter text - set attribute "value"

        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click", loginButton);

        BrowserUtils.wait(4);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();
        Assert.assertEquals(subheader, expected);
    }

    @Test
    public void scrollToElement() {
        //href = link, URL
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", link);
    }

    @Test
    public void scrollTest(){

        driver.navigate().to("");
    }



    @Test
    public void verifyTitle(){
        String expected = "Practice";
        // we create javaScript executor object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //executeScript - this method executes javascript code
        // we provide js code as a String
        String actual = js.executeScript("return document.title").toString();

        Assert.assertEquals(actual, expected);

    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }


}
