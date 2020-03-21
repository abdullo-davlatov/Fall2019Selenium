package com.automation.tests.day9.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneNumberBy = By.name("phone");

    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    private By signBy = By.id("wooden_spoon");


    @Test
    public void test1(){
        driver.findElement(firstNameBy).sendKeys("Patrick");
        BrowserUtils.wait(1);
        driver.findElement(lastNameBy).sendKeys("White");
        BrowserUtils.wait(1);
        driver.findElement(userNameBy).sendKeys("testuser");
        BrowserUtils.wait(1);
        driver.findElement(emailBy).sendKeys("test@email.com");
        BrowserUtils.wait(1);
        driver.findElement(passwordBy).sendKeys("12345678");
        BrowserUtils.wait(1);
        driver.findElement(phoneNumberBy).sendKeys("234-123-1231");
        BrowserUtils.wait(1);

        driver.findElement(maleBy).click();
        BrowserUtils.wait(1);
        driver.findElement(dateBirthBy).sendKeys("01/02/1940");
        BrowserUtils.wait(1);

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        BrowserUtils.wait(1);
        departmentSelect.selectByVisibleText("Department of Agriculture");
        BrowserUtils.wait(1);

        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        BrowserUtils.wait(1);
        jobTitleSelect.selectByVisibleText("SDET");
        BrowserUtils.wait(1);

        driver.findElement(javaBy).click();
        BrowserUtils.wait(1);

        driver.findElement(signBy).click();

        BrowserUtils.wait(5);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMassage = driver.findElement(By.xpath("first name can only consist of alphabetical letters"));
        Assert.assertTrue(warningMassage.isDisplayed());
    }

    @Test
    public void verifyAlphabeticLettersOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warningMassage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMassage.isDisplayed());
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
