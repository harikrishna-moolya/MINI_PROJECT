package com.project.pages;

import com.project.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
    private WebDriver driver;
    private Waits waits;

    // Placeholder; SauceDemo doesn't maintain order history UI
    private By ordersLink = By.id("orders-link");
    private By ordersTable = By.id("order-list");

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public void openOrders() {
        try { driver.findElement(ordersLink).click(); } catch (Exception ignored) {}
    }

    public boolean hasOrders() {
        try { return driver.findElement(ordersTable).isDisplayed(); } catch (Exception e) { return false; }
    }
}
