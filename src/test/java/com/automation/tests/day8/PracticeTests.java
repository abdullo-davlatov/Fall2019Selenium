package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {
    private WebDriver driver;



    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void loginTest(){
        //go to "Form Authentication" page
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters: (expected, actual, "message in case of error")
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }

    @Test
    public void forgotPasswordTest(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("email")).sendKeys("abdullotjooon@gmail.com", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_messager")).getText();
        Assert.assertEquals(actual, expected, "massage is not match");

    }

    @Test
    public void checkboxTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(3);
        //driver.findElement(By.xpath("//html//body//div[1]/form/input[1]")).click();
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(3);
        checkboxes.get(0).click();

        Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox #1 is not selected!");
        BrowserUtils.wait(3);

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
