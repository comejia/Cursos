package com.seleniumdesign.test.decorator;

import com.seleniumdesign.decorator.PaymentScreenPage;
import com.seleniumdesign.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Consumer;

import static com.seleniumdesign.test.decorator.PaymentDecorators.*;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreenPage paymentScreenPage;

    @BeforeEach
    public void setPaymentScreenPage() {
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }

    @ParameterizedTest
    @MethodSource("getData")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {
        this.paymentScreenPage.goTo();
        consumer.accept(this.paymentScreenPage);
    }

    static Object[] getData() {
        return new Object[] {
                validCC.andThen(buy).andThen(successfullPurchase),
                freeCoupon.andThen(buy).andThen(successfullPurchase),
                discountedCoupon.andThen(validCC).andThen(buy).andThen(successfullPurchase),
                invalidCC.andThen(buy).andThen(failedPurchase),
                invalidCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
                buy.andThen(failedPurchase)
        };
    }
}
