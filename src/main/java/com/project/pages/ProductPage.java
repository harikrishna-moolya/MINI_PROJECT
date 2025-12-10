package com.project.pages;

import com.project.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;
    private Waits waits;

    private By productNames = By.cssSelector(".inventory_item_name");
    private By addToCartButtons = By.cssSelector("button.btn_inventory");
    private By cartIcon = By.id("shopping_cart_container");
    private By sortSelect = By.cssSelector(".product_sort_container");
    private By itemPrice = By.cssSelector(".inventory_item_price");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public int getProductCount() {
        return driver.findElements(productNames).size();
    }

    public void addProductByName(String name) {
        List<WebElement> names = driver.findElements(productNames);
        List<WebElement> adds = driver.findElements(addToCartButtons);
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(name)) {
                adds.get(i).click();
                return;
            }
        }
        throw new RuntimeException("Product not found: " + name);
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public double[] getPrices() {
        List<WebElement> prices = driver.findElements(itemPrice);
        double[] arr = new double[prices.size()];
        for (int i = 0; i < prices.size(); i++) {
            arr[i] = Double.parseDouble(prices.get(i).getText().replace("$", ""));
        }
        return arr;
    }
}
