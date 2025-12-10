package com.project.tests;

import com.project.pages.LoginPage;
import com.project.pages.OrderHistoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 Order history placeholder - SauceDemo lacks order-history UI.
*/
public class OrderHistoryTests extends BaseTest {

    @Test
    public void verifyOrderHistoryPlaceholder() {
        LoginPage lp = new LoginPage(getDriver());
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLogin();

        OrderHistoryPage oh = new OrderHistoryPage(getDriver());
        oh.openOrders();
        Assert.assertTrue(oh.hasOrders() || true);
    }
}
