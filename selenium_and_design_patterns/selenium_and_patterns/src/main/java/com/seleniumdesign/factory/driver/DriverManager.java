package com.seleniumdesign.factory.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createDriver();

    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }
}
