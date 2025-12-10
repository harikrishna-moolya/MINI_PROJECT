package com.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    public static WebDriver createInstance(String browser) {

        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // Use a fresh temporary user profile
            String tempProfile = System.getProperty("java.io.tmpdir") + "chromeProfile";
            options.addArguments("user-data-dir=" + tempProfile);

            // Incognito mode to prevent Chrome from loading any saved passwords
            options.addArguments("--incognito");

            // Disable Chrome Password Manager
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Disable password breach alerts + suggestions
            options.addArguments("--disable-features=PasswordManagerEnabled,DetectionOfCompromisedPasswords,PasswordChange");

            // Disable other popups and notifications
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-password-manager-reauthentication");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");

            // Needed for ChromeDriver 111+
            options.addArguments("--remote-allow-origins=*");

            return new ChromeDriver(options);
        }

        throw new RuntimeException("Unsupported browser: " + browser);
    }
}
