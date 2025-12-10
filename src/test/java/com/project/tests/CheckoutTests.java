package com.project.tests;

import com.project.pages.CartPage;
import com.project.pages.CheckoutPage;
import com.project.pages.LoginPage;
import com.project.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutEndToEnd() {

        LoginPage lp = new LoginPage(getDriver());
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLogin();

        ProductPage pp = new ProductPage(getDriver());
        pp.addProductByName("Sauce Labs Backpack");
        pp.openCart();

        CartPage cp = new CartPage(getDriver());
        cp.clickCheckout();

        CheckoutPage chk = new CheckoutPage(getDriver());
        chk.enterCheckoutInfo("Hari", "Krishna", "500001");
        chk.continueCheckout();
        chk.finishOrder();

        String msg = chk.getConfirmationText();
        Assert.assertTrue(msg.toLowerCase().contains("thank"), "Order confirmation should be visible");
    }

    @Test
    public void checkoutValidationNegative() {

        LoginPage lp = new LoginPage(getDriver());
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLogin();

        ProductPage pp = new ProductPage(getDriver());
        pp.addProductByName("Sauce Labs Backpack");
        pp.openCart();

        CartPage cp = new CartPage(getDriver());
        cp.clickCheckout();

        CheckoutPage chk = new CheckoutPage(getDriver());
        chk.enterCheckoutInfo("", "Krishna", "500001");
        chk.continueCheckout();

        Assert.assertTrue(getDriver().getPageSource().toLowerCase().contains("error"));
    }
}
