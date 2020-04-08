package com.automation.tests.day9.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.day9.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {


    @Test
    public void verifyPageTitle(){
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard"); //Dashboard
        BrowserUtils.wait(3);
        test.pass("page title Dashboard is verified");

    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        BrowserUtils.wait(3);
        loginPage.login("wrong", "wrong");
        BrowserUtils.wait(3);
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        // take a screenshot
//        BrowserUtils.getScreenshot("Warnning massage");
        BrowserUtils.getScreenshot("loginPaagge");

        test.pass("Warning message is displayed");
    }

    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName, String password) {
        test = report.createTest("Verify page title as " + userName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        test.info("Login as " + userName);//log some steps
        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");
    }

    //Object[][] or Object[] or Iterator<Object[]>
    //Object[] - 1 column with a data
    //Object[][] 2+
    @DataProvider
    public Object[][] credentials() {
        return new Object[][]{
                {"storemanager85", "UserUser123"},
                {"salesmanager110", "UserUser123"},
                {"user16", "UserUser123"},
        };
    }


}
