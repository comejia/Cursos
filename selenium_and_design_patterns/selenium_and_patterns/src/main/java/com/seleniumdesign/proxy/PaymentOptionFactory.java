package com.seleniumdesign.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {
    // Factory pattern implementation with Supplier function
    // Use this when you don't need to give any param
    private static final Supplier<PaymentOption> CC = CreditCard::new;
    private static final Supplier<PaymentOption> NB = NetBanking::new;

    private static final Map<String, Supplier<PaymentOption>> map = new HashMap<>();

    static {
        map.put("CC", CC);
        map.put("NB", NB);
    }

    public static PaymentOption get(String option) {
        return map.get(option).get();
    }

}
