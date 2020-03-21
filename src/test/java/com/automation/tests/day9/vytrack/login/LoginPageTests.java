package com.automation.tests.day9.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTests {

    private WebDriver driver;
    //https is a secured version of http protocol
    //http - it's hypertext transfer protocol that every single website is using now days
    //https - data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text, very easy to hack it
    private String URL = "https://qa2.vytrack.com/user/login";
//    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    // > in css selector means same thing as / in xpath - direct child
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");
    @Test (description = "Login as store manager and verify title is equal to Dashboard  ")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(actual,expected, "Page title is not correct");
    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
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
