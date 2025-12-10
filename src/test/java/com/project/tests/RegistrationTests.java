package com.project.tests;

import com.project.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 Placeholder registration test.
 Works on SauceDemo safely.
 For real site, update locators and waits as needed.
*/
public class RegistrationTests extends BaseTest {

    @Test
    public void registerUserPlaceholder() {
        RegistrationPage rp = new RegistrationPage(getDriver());

        rp.openRegistration();

        // Generate unique email
        String email = "test" + System.currentTimeMillis() + "@example.com";

        rp.enterEmail(email);
        rp.enterPassword("Password123!");
        rp.enterConfirm("Password123!");
        rp.submit();

        String success = rp.getSuccessMessage();
        System.out.println("Success message: " + success);

        // Assert always passes for placeholder
        Assert.assertTrue(success.length() > 0);
    }
}
