package com.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DismissAlertValidator extends ElementValidator {

    private final WebElement dismissAlert;

    public DismissAlertValidator(final WebElement element) {
        this.dismissAlert = element;
    }

    @Override
    public boolean validate() {
        boolean result2 = false;
        boolean result1 = this.dismissAlert.isDisplayed();
        this.dismissAlert.findElement(By.cssSelector("button.close")).click();
        try {
            result2 = this.dismissAlert.isDisplayed();
        } catch(NoSuchElementException ignore) { }
        return result1 && !result2;
    }
}
