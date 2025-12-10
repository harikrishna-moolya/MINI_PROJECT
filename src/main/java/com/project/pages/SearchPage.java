package com.project.pages;

import com.project.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private Waits waits;

    // Note: SauceDemo does not provide a search input; this is placeholder for AutomationPractice.
    private By searchBox = By.id("search_query_top");
    private By searchBtn = By.name("submit_search");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public void search(String query) {
        try {
            waits.untilVisible(searchBox).clear();
            driver.findElement(searchBox).sendKeys(query);
            driver.findElement(searchBtn).click();
        } catch (Exception ignored) {}
    }
}
