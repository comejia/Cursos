package com.seleniumdesign.templatemethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

public class EBayShopping extends ShoppingTemplate {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String product;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;
    @FindBy(id = "gh-btn")
    private WebElement searchBtn;
    @FindBy(xpath = "//div[@id='srp-river-results']//div/a[@class='s-item__link']")
    private WebElement item;
    @FindBy(id = "prcIsum")
    private WebElement price;

    public EBayShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.product = product;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com");
    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until(d -> this.item.isDisplayed());
        this.item.click();
    }

    @Override
    public void buy() {
        String parent = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        windows.forEach(w -> {
            if(!parent.equals(w)) {
                driver.switchTo().window(w);
            }
        });
        this.wait.until(d -> this.price.isDisplayed());
        System.out.println(this.price.getText());
    }
}
