package com.project.pages;

import com.project.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private Waits waits;

    // locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By error = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    // actions
    public void enterUsername(String u) {
        waits.untilVisible(username).clear();
        driver.findElement(username).sendKeys(u);
    }

    public void enterPassword(String p) {
        waits.untilVisible(password).clear();
        driver.findElement(password).sendKeys(p);
    }

    public void clickLogin() {
        waits.untilClickable(loginBtn).click();
    }

    public String getErrorMessage() {
        try {
            return waits.untilVisible(error).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
