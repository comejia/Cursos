package com.seleniumdesign.templatemethod;

import com.seleniumdesign.templatemethod.pages.AmazonProductDescriptionPage;
import com.seleniumdesign.templatemethod.pages.AmazonResultPage;
import com.seleniumdesign.templatemethod.pages.AmazonSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonShopping extends ShoppingTemplate {

    private final WebDriver driver;
    private final String product;

    private final AmazonSearchPage amazonSearchPage;
    private final AmazonResultPage amazonResultPage;
    private final AmazonProductDescriptionPage amazonProductDescriptionPage;


    public AmazonShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultPage = PageFactory.initElements(driver, AmazonResultPage.class);
        this.amazonProductDescriptionPage = PageFactory.initElements(driver, AmazonProductDescriptionPage.class);
    }

    @Override
    public void launchSite() {
        this.amazonSearchPage.goTo();

    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.searchForProduct(this.product);
    }

    @Override
    public void selectProduct() {
        this.amazonResultPage.selectProduct();
    }

    @Override
    public void buy() {
        this.amazonProductDescriptionPage.buy();
    }
}
