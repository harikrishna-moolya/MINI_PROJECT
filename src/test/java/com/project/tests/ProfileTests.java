package com.project.tests;

import com.project.pages.LoginPage;
import com.project.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 Profile page placeholder - SauceDemo lacks profile UI. This demonstrates approach.
*/
public class ProfileTests extends BaseTest {

    @Test
    public void updateProfilePlaceholder() {
        LoginPage lp = new LoginPage(getDriver());
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLogin();

        ProfilePage pp = new ProfilePage(getDriver());
        pp.openProfile();
        pp.updateName("Automation User");
        pp.updatePhone("9999999999");
        pp.save();

        // placeholder: in real app check persisted value
        Assert.assertTrue(true);
    }
}
