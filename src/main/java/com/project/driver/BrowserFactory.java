package com.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    public static WebDriver createInstance(String browser) {

        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // Jenkins-safe temporary Chrome profile
            String tempProfile = System.getProperty("user.dir") + "/chrome-profile";
            options.addArguments("--user-data-dir=" + tempProfile);
            options.addArguments("--disk-cache-dir=" + tempProfile + "/cache");

            // Headless mode for Jenkins (safe for local too)
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            // Incognito mode + disable password manager
            options.addArguments("--incognito");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Disable password breach warnings
            options.addArguments("--disable-features=PasswordManagerEnabled,DetectionOfCompromisedPasswords,PasswordChange");

            // Disable popups, notifications
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-password-manager-reauthentication");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");

            // Required for newer Chrome versions
            options.addArguments("--remote-allow-origins=*");

            return new ChromeDriver(options);
        }

        throw new RuntimeException("Unsupported browser: " + browser);
    }
}
