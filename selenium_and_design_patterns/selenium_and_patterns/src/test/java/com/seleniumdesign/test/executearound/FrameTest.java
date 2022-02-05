package com.seleniumdesign.test.executearound;

import com.seleniumdesign.executearound.MainPage;
import com.seleniumdesign.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {
        this.mainPage.goTo();

        // Different examples to use lambda
        this.mainPage.onFrameA(fa -> fa.setLastName("ln1"));
        this.mainPage.onFrameA(a -> {
            a.setFirstName("fn1");
            a.setMessage("I am going to fill text area");
        });
        this.mainPage.onFrameC(fc -> fc.setAddress("address for frameC"));
        this.mainPage.onFrameB(fb -> fb.setMessage("this is for Frame B"));
    }
}
