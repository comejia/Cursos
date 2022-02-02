package com.seleniumdesign.templatemethod.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductDescriptionPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//span[contains(@class, 'apexPriceToPay')]/span[2]")
    private WebElement price;

    public AmazonProductDescriptionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void buy() {
        this.wait.until(d -> this.price.isDisplayed());
        System.out.println(this.price.getText());
    }
}
