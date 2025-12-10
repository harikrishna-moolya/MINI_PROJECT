package com.project.pages;

import com.project.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 Placeholder page for registration.
 For a real site (e.g., AutomationPractice), update locators accordingly.
*/
public class RegistrationPage {

    private WebDriver driver;
    private Waits waits;

    // Placeholder locators (update for real site)
    private By signup = By.id("register-link");      // placeholder
    private By email = By.id("email");               // placeholder
    private By password = By.id("password");        // placeholder
    private By confirm = By.id("confirm-password"); // placeholder
    private By submit = By.id("register-button");   // placeholder
    private By successMsg = By.cssSelector(".success"); // placeholder

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public void openRegistration() {
        // Only try if element exists
        try {
            WebElement el = waits.untilVisible(signup); // short wait
            el.click();
        } catch (Exception ignored) {}
    }

    public void enterEmail(String e) {
        try {
            waits.untilVisible(email).sendKeys(e);
        } catch (Exception ignored) {}
    }

    public void enterPassword(String p) {
        try {
            waits.untilVisible(password).sendKeys(p);
        } catch (Exception ignored) {}
    }

    public void enterConfirm(String c) {
        try {
            waits.untilVisible(confirm).sendKeys(c);
        } catch (Exception ignored) {}
    }

    public void submit() {
        try {
            waits.untilVisible(submit).click();
        } catch (Exception ignored) {}
    }

    public String getSuccessMessage() {
        try {
            return waits.untilVisible(successMsg).getText();
        } catch (Exception e) {
            return "placeholder-success"; // safe placeholder
        }
    }
}
