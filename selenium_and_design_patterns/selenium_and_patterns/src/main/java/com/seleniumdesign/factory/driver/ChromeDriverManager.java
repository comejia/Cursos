package com.seleniumdesign.factory.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ChromeDriverManager extends DriverManager {

    @Override
    protected void createDriver() {
        driver = new ChromeDriver(getDefaultOptions());
    }

    private ChromeOptions getDefaultOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        return options;
    }

}
