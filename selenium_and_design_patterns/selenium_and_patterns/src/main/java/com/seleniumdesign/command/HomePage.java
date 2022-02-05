package com.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private final WebDriver driver;

    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;
    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warningBtn;
    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;
    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;

    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;
    @FindBy(css = "div.jq-icon-warning")
    private WebElement warningAlert;
    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;
    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //@FindBy(css = "div.card-body div.row div:nth-child(2) div.alert-info")
    @FindBy(xpath = "//div[h4[text()='Dissmissal Alert']]/div[contains(@class, 'alert-info')]")
    private WebElement dismissInfoAlert;
    //@FindBy(css = "div.card-body div.row div:nth-child(2) div.alert-success")
    @FindBy(xpath = "//div[h4[text()='Dissmissal Alert']]/div[contains(@class, 'alert-success')]")
    private WebElement dismissSuccessAlert;
    //@FindBy(css = "div.card-body div.row div:nth-child(2) div.alert-danger")
    @FindBy(xpath = "//div[h4[text()='Dissmissal Alert']]/div[contains(@class, 'alert-danger')]")
    private WebElement dismissDangerAlert;
    //@FindBy(css = "div.card-body div.row div:nth-child(2) div.alert-warning")
    @FindBy(xpath = "//div[h4[text()='Dissmissal Alert']]/div[contains(@class, 'alert-warning')]")
    private WebElement dismissWarningAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {
        return List.of(
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(warningBtn, warningAlert),
                new NotificationValidator(dangerBtn, dangerAlert),

                new DismissAlertValidator(dismissInfoAlert),
                new DismissAlertValidator(dismissSuccessAlert),
                new DismissAlertValidator(dismissWarningAlert),
                new DismissAlertValidator(dismissDangerAlert)
        );
    }
}
