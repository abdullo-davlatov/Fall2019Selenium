package com.automation.tests.WarmUp;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class March4 {
    static WebDriver driver;
    public static void main(String[] args) throws Exception {
        ebayTest();
        amazonTest();
        wikiTest();
    }
    public static void ebayTest(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);

        driver.quit();
    }
    public static void amazonTest(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title = driver.getTitle();
        if (title.contains("java book")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
    public static void wikiTest() throws Exception{
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String link = driver.getCurrentUrl(); // to get link as a String
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }

    // @channel WARM-UP
    //Go to ebay
    //enter search term
    //click on search button
    //print number of results
    //go to amazon
    //Go to ebay
    //enter search term
    //click on search button
    //verify title contains search term
    //Go to wikipedia.org
    //enter search term `selenium webdriver`
    //click on search button
    //click on search result `Selenium (software)`
    //verify url ends with `Selenium_(software)`

}
