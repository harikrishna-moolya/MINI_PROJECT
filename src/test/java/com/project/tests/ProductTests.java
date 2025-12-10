package com.project.tests;

import com.project.pages.LoginPage;
import com.project.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test
    public void productListVisibleAndAddToCart() {
        LoginPage lp = new LoginPage(getDriver());
        lp.enterUsername(System.getProperty("username", "standard_user"));
        lp.enterPassword(System.getProperty("password", "secret_sauce"));
        lp.clickLogin();

        ProductPage pp = new ProductPage(getDriver());
        Assert.assertTrue(pp.getProductCount() > 0, "Product list should be visible");
        pp.addProductByName("Sauce Labs Backpack");
        pp.openCart();
        Assert.assertTrue(getDriver().getPageSource().contains("Sauce Labs Backpack"), "Added product must appear in cart");
    }
}
