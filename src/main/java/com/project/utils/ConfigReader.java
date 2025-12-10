package com.project.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config/config.properties")) {
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config/config.properties", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
