package com.seleniumdesign.test.templatemethod;

import com.seleniumdesign.factory.driver.DriverManagerFactory;
import com.seleniumdesign.templatemethod.AmazonShopping;
import com.seleniumdesign.templatemethod.EBayShopping;
import com.seleniumdesign.templatemethod.ShoppingTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

public class ShoppingTest {

    protected static WebDriver driver;

    @BeforeAll
    static void setupDriver() {
        driver = DriverManagerFactory.CHROME.getDriverManager().getDriver();
    }

    @AfterAll
    static void quit() {
        driver.quit();
    }

    @ParameterizedTest
    @MethodSource("getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();
    }

    static Object[] getData() {
        return new Object[] {
                new AmazonShopping(driver, "samsung"),
                new EBayShopping(driver, "samsung")
        };
    }
}
