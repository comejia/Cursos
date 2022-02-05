package com.seleniumdesign.test.commnad;

import com.seleniumdesign.command.ElementValidator;
import com.seleniumdesign.command.HomePage;
import com.seleniumdesign.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomaPageTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void setupHomaPage() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ElementValidator::validate)
                .forEach(Assertions::assertTrue);
    }
}
