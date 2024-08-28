package org.example;

import java.io.IOException;
import java.util.Properties;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Config {

    public static final String PRODUCT_URL;
    public static final String HUB_SELENIUM_URL;
    public static final String WEB_BROWSER_NAME;
    public static final Long BROWSER_TIMEOUT;
    public static final String USER_LOGIN;
    public static final String USER_PASSWORD;

    private static final String configPath = "config.properties";
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream(configPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            PRODUCT_URL = getPropertyValue(
                    "productUrl",
                    "product.url",
                    "PRODUCT_URL",
                    "");
            HUB_SELENIUM_URL = getPropertyValue(
                    "hubSeleniumUrl",
                    "hub.selenium.url",
                    "HUB_SELENIUM_URL",
                    "");
            WEB_BROWSER_NAME = getPropertyValue(
                    "webBrowserName",
                    "web.browser.name",
                    "WEB_BROWSER_NAME",
                    "");
            BROWSER_TIMEOUT = Long.valueOf(getPropertyValue(
                    "browserTimeout",
                    "browser.timeout",
                    "BROWSER_TIMEOUT",
                    ""));
            USER_LOGIN = getPropertyValue(
                    "userLogin",
                    "user.login",
                    "USER_LOGIN",
                    "");
            USER_PASSWORD = getPropertyValue(
                    "userPassword",
                    "user.password",
                    "USER_PASSWORD",
                    "");
        }
    }

    private static String getPropertyValue(String sysParamKey, String propertyKey, String envKey,
                                           String defValue) {
        String systemParamValue = System.getProperty(sysParamKey);
        if (!isNullOrEmpty(systemParamValue)) {
            return systemParamValue;
        }
        String envParamValue = System.getenv(envKey);
        if (!isNullOrEmpty(envParamValue)) {
            return envParamValue;
        }
        String propertiesParamValue = properties.getProperty(propertyKey);
        if (!isNullOrEmpty(propertiesParamValue)) {
            return propertiesParamValue;
        }
        return defValue;
    }
}
