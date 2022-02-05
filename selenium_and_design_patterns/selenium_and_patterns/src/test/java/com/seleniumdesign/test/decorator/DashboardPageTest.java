package com.seleniumdesign.test.decorator;

import com.seleniumdesign.decorator.DashboardPage;
import com.seleniumdesign.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeEach
    public void setDashboardPage() {
        this.dashboardPage = new DashboardPage(driver);
    }

    @ParameterizedTest
    @MethodSource("getData")
    public void roleTest(Consumer<DashboardPage> role) {
        this.dashboardPage.goTo();
        role.accept(this.dashboardPage);
    }

    static Object[] getData() {
        return new Object[] {
                Decorators.guestPage,
                Decorators.superUserPage,
                Decorators.adminPage
        };
    }

}
