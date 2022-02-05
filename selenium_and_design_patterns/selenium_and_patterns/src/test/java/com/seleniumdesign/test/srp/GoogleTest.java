package com.seleniumdesign.test.srp;

import com.seleniumdesign.srp.main.GoogleMainPage;
import com.seleniumdesign.srp.result.GoogleResultPage;
import com.seleniumdesign.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeEach
    public void setupPages() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @ParameterizedTest
    @MethodSource("getData")
    public void googleWorkflow(String keyword, int index) {
        googleMainPage.goTo();
        assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(keyword);
        assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();

        System.out.println(googleResultPage.getResultStat().getStat());
    }

    static Object[][] getData() {
        return new Object[][] {
                {"selenium", 4},
                {"docker", 2}
        };
    }

}
