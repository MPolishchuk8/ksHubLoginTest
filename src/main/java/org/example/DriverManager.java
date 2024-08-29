package org.example;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public WebDriver initWebDriver(DesiredCapabilities defCapabilities) {
        Configuration.timeout = Config.BROWSER_TIMEOUT;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities = capabilities.merge(defCapabilities);
        capabilities.setBrowserName(Config.WEB_BROWSER_NAME);
        capabilities.setAcceptInsecureCerts(true);
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(Config.HUB_SELENIUM_URL), capabilities);
            driver.setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
