package com.seleniumdesign.test.decorator;

import com.seleniumdesign.decorator.DashboardPage;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> assertFalse(element.isDisplayed()));
    }

    // ingredients
    private static final Consumer<DashboardPage> adminComponentPresent =
            dashboard -> shouldDisplay(dashboard.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresent =
            dashboard -> shouldNotDisplay(dashboard.getAdminComponents());

    private static final Consumer<DashboardPage> guestComponentPresent =
            dashboard -> shouldDisplay(dashboard.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentNotPresent =
            dashboard -> shouldNotDisplay(dashboard.getGuestComponents());

    private static final Consumer<DashboardPage> superUserComponentPresent =
            dashboard -> shouldDisplay(dashboard.getSuperUserComponents());
    private static final Consumer<DashboardPage> superUserComponentNotPresent =
            dashboard -> shouldNotDisplay(dashboard.getSuperUserComponents());

    // role selection
    private static final Consumer<DashboardPage> adminSelection = dashboard -> dashboard.selectRole("admin");
    private static final Consumer<DashboardPage> superUserSelection = dashboard -> dashboard.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection = dashboard -> dashboard.selectRole("guest");

    // user role pages
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresent)
                    .andThen(superUserComponentNotPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> superUserPage = superUserSelection.andThen(guestComponentPresent)
            .andThen(superUserComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(guestComponentPresent)
            .andThen(superUserComponentPresent).andThen(adminComponentPresent);
}
