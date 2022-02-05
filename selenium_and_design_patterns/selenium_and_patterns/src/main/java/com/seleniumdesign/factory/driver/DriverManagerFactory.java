package com.seleniumdesign.factory.driver;

public enum DriverManagerFactory {

    // Factory pattern implementation with an enum class
    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    },
    FIREFOX {
        @Override
        public DriverManager getDriverManager() {
            return new FirefoxDriverManager();
        }
    };

    public abstract DriverManager getDriverManager();
}
