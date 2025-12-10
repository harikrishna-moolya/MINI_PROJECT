package com.project.tests;

import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {ConfigReader.get("username.standard"), ConfigReader.get("password.standard"), true},
                {ConfigReader.get("username.standard"), "wrongpass", false},
                {ConfigReader.get("username.locked"), ConfigReader.get("password.locked"), false}
        };
    }

    @Test(dataProvider = "loginData", retryAnalyzer = com.project.utils.RetryAnalyzer.class)
    public void loginTest(String username, String password, boolean shouldPass) {
        LoginPage lp = new LoginPage(getDriver());
        lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLogin();

        if (shouldPass) {
            HomePage hp = new HomePage(getDriver());
            Assert.assertTrue(hp.isDisplayed(), "Expected home page to be displayed after login");
        } else {
            Assert.assertTrue(lp.getErrorMessage().length() > 0, "Expected error message for invalid login");
        }
    }
}
