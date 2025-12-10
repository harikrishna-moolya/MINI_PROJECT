package com.project.tests;

import com.project.pages.CartPage;
import com.project.pages.LoginPage;
import com.project.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void addAndRemoveFromCart() {
        LoginPage lp = new LoginPage(getDriver());
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLogin();

        ProductPage pp = new ProductPage(getDriver());
        pp.addProductByName("Sauce Labs Backpack");
        pp.openCart();

        Assert.assertTrue(getDriver().getPageSource().contains("Sauce Labs Backpack"));

        CartPage cp = new CartPage(getDriver());
        cp.removeAllItemsIfAny();
        // after removal, product should not be present
        Assert.assertFalse(getDriver().getPageSource().contains("Sauce Labs Backpack"));
    }
}
