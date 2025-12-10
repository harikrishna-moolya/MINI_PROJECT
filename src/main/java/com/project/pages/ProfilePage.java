package com.project.pages;

import com.project.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 Note: SauceDemo doesn't provide a real profile page. This is a placeholder
 to show pattern; for real profile tests use AutomationPractice or another site.
*/
public class ProfilePage {
    private WebDriver driver;
    private Waits waits;

    // placeholder locators
    private By profileLink = By.id("profile-link");
    private By nameField = By.id("profile-name");
    private By phoneField = By.id("profile-phone");
    private By saveBtn = By.id("save-profile");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public void openProfile() {
        try { driver.findElement(profileLink).click(); } catch (Exception ignore) {}
    }

    public void updateName(String name) {
        try {
            waits.untilVisible(nameField).clear();
            driver.findElement(nameField).sendKeys(name);
        } catch (Exception ignored) {}
    }

    public void updatePhone(String phone) {
        try {
            driver.findElement(phoneField).clear();
            driver.findElement(phoneField).sendKeys(phone);
        } catch (Exception ignored) {}
    }

    public void save() {
        try { driver.findElement(saveBtn).click(); } catch (Exception ignored) {}
    }
}
