package com.seleniumdesign.command;

import org.openqa.selenium.WebElement;

public class NotificationValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;

    public NotificationValidator(final WebElement button, final WebElement notification) {
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        this.button.click();
        boolean appearanceState = this.notification.isDisplayed();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean disappearanceState = this.notification.isDisplayed();
        return appearanceState && !disappearanceState;
    }
}
