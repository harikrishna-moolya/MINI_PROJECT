package com.project.pages;

import com.project.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private Waits waits;

    private By checkoutBtn = By.id("checkout");
    private By removeBtn = By.cssSelector("button.cart_button");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public void clickCheckout() {
        waits.untilClickable(checkoutBtn).click();
    }

    public void removeAllItemsIfAny() {
        try {
            while (!driver.findElements(removeBtn).isEmpty()) {
                driver.findElements(removeBtn).get(0).click();
            }
        } catch (Exception ignored) {}
    }
}
