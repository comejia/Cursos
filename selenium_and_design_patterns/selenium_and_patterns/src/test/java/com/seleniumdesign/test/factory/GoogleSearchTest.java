package com.seleniumdesign.test.factory;

import com.seleniumdesign.factory.GoogleFactory;
import com.seleniumdesign.factory.GooglePage;
import com.seleniumdesign.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @ParameterizedTest
    @MethodSource("getData")
    public void searchTest(String language, String keyword) {
        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultsCount();

        System.out.println("Result count: " + resultCount);
    }

    static Object[][] getData() {
        return new Object[][] {
                {"ENG", "selenium"},
                {"FR", "desing patterns"},
                {"SA", "docker"},
                {"ES", "jenkins"}
        };
    }
}
