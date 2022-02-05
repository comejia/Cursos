package com.seleniumdesign.test.decorator;

import com.seleniumdesign.decorator.PaymentScreenPage;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentDecorators {

    // actions
    public static final Consumer<PaymentScreenPage> freeCoupon = p -> p.applyPromoCode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage> discountedCoupon = p -> p.applyPromoCode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage> validCC = p -> p.enterCC("4111111111111111", "2023", "123");
    public static final Consumer<PaymentScreenPage> invalidCC = p -> p.enterCC("4111111111111112", "2023", "123");
    public static final Consumer<PaymentScreenPage> buy = PaymentScreenPage::buyProduct;

    // validations
    public static final Consumer<PaymentScreenPage> successfullPurchase = p -> assertEquals(p.getStatus(), "PASS");
    public static final Consumer<PaymentScreenPage> failedPurchase = p -> assertEquals(p.getStatus(), "FAIL");
}
