package com.seleniumdesign.factory.driver;

public enum DriverManagerFactory {

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
