package com.automation.tests.day9.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesPageTests {
    private String URL = "https://qa2.vytrack.com/user/login";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private WebDriver driver;
    @Test
    public void verifyPageSubTitle(){
//################################################################
        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
        String expected = "All Cars";
        String actual = subTitleElement.getText();
        Assert.assertEquals(actual, expected);
    }
    /**
     *
     *     ################ TASK 7 minutes until 3:48
     *
     *     Given user is on the vytrack landing page
     *     When user logs on as a store manager
     *     Then user navigates to Fleet --> Vehicles
     *     And user verifies that page number is equals to "1"
     */
    @Test
    public void verifyPageNumber(){
        String expected = "1";
        String actual = "";


    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        //login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        //put more wait here as well, if didn't click
        BrowserUtils.wait(5);
        //click on fleet
//        driver.findElement(fleetBy).click();
        //Actions class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        //move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        //perform - to execute command
        //every action should end with perform()
        BrowserUtils.wait(2);
        //click on Vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        //put more wait time if you are getting Cars, Dashboard...
        //this application is slooooow...
        BrowserUtils.wait(5);
    }
    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }


}
