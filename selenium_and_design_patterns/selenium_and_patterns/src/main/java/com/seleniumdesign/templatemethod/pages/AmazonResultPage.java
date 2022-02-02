package com.seleniumdesign.templatemethod.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonResultPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    public AmazonResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        this.wait.until(d -> this.item.isDisplayed());
        this.item.click();
    }
}
