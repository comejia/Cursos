package com.seleniumdesign.test;

import com.seleniumdesign.factory.driver.DriverManager;
import com.seleniumdesign.factory.driver.DriverManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    private DriverManager driverManager;
    protected WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        this.driverManager = DriverManagerFactory.CHROME.getDriverManager();
        this.driver = driverManager.getDriver();
    }

    @AfterEach
    public void tearDown() {
        this.driverManager.quitDriver();
    }
}
