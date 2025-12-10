package com.project.pages;

import com.project.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    private Waits waits;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postal = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By confirmation = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public void enterCheckoutInfo(String f, String l, String p) {
        waits.untilVisible(firstName).sendKeys(f);
        driver.findElement(lastName).sendKeys(l);
        driver.findElement(postal).sendKeys(p);
    }

    public void continueCheckout() {
        driver.findElement(continueBtn).click();
    }

    public void finishOrder() {
        driver.findElement(finishBtn).click();
    }

    public String getConfirmationText() {
        try {
            return waits.untilVisible(confirmation).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
