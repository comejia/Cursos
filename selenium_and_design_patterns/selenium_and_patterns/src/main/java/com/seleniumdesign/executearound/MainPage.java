package com.seleniumdesign.executearound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class MainPage {

    private final WebDriver driver;

    @FindBy(id = "a")
    private WebElement a;
    @FindBy(id = "b")
    private WebElement b;
    @FindBy(id = "c")
    private WebElement c;

    private final FrameA frameA;
    private final FrameB frameB;
    private final FrameC frameC;

    public MainPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.frameA = PageFactory.initElements(driver, FrameA.class);
        this.frameB = PageFactory.initElements(driver, FrameB.class);
        this.frameC = PageFactory.initElements(driver, FrameC.class);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    public void onFrameA(Consumer<FrameA> consumer) {
        this.driver.switchTo().frame(this.a);
        consumer.accept(this.frameA);
        this.driver.switchTo().defaultContent();
    }
    public void onFrameB(Consumer<FrameB> consumer) {
        this.driver.switchTo().frame(this.b);
        consumer.accept(this.frameB);
        this.driver.switchTo().defaultContent();
    }
    public void onFrameC(Consumer<FrameC> consumer) {
        this.driver.switchTo().frame(this.c);
        consumer.accept(this.frameC);
        this.driver.switchTo().defaultContent();
    }
}
