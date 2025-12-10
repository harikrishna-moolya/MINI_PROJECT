package com.project.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
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

            // Automatically downloads correct ChromeDriver
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // ---- REQUIRED FOR JENKINS ----
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");

            // Disable notifications + password popups
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            options.setExperimentalOption("prefs", prefs);

            // Incognito mode
            options.addArguments("--incognito");

            // Disable password-related warnings
            options.addArguments("--disable-features=PasswordManagerEnabled");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");

            // Temporary profile (works in Jenkins)
            String tempProfile = System.getProperty("java.io.tmpdir") + "/chromeProfile";
            options.addArguments("user-data-dir=" + tempProfile);

            return new ChromeDriver(options);
        }

        throw new RuntimeException("Unsupported browser: " + browser);
    }
}
