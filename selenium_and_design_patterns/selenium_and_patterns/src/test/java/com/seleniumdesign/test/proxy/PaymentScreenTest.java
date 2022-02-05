package com.seleniumdesign.test.proxy;

import com.seleniumdesign.proxy.PaymentOptionFactory;
import com.seleniumdesign.proxy.PaymentScreen;
import com.seleniumdesign.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeEach
    public void setPaymentScreen() {
        System.setProperty("env", "PROD");
        this.paymentScreen = new PaymentScreen(this.driver);
    }


    @ParameterizedTest
    @MethodSource("getData")
    public void paymentTest(String option, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("cesar", "mejia", "udemy@gmail.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();

        System.out.println("Order number: " + orderNumber);
    }

    static Object[][] getData() {
        Map<String, String> cc = new HashMap<>();
        cc.put("cc", "123123123");
        cc.put("year", "2022");
        cc.put("cvv", "123");

        Map<String, String> nb = new HashMap<>();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "456654ABC");
        nb.put("pin", "666");

        return new Object[][] {
                {"CC", cc},
                {"NB", nb}
        };
    }

}
