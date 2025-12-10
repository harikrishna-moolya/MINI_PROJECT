package com.project.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String dest = "target/screenshots/" + testName + "_" + timestamp + ".png";
            File destFile = new File(dest);
            destFile.getParentFile().mkdirs();
            FileUtils.copyFile(src, destFile);
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
