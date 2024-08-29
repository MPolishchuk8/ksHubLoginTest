package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Set;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        initWebDriver(capabilities);
    }

    private void initWebDriver(final DesiredCapabilities defCapabilities) {
        WebDriver driver = new DriverManager().initWebDriver(defCapabilities);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    public void switchToWindow(String urlPrefix) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        String currentHandle = "";
        try {
            currentHandle = driver.getWindowHandle();
        } catch (Exception ignored) {}
        Set<String> allWinHandles = driver.getWindowHandles();
        for (String handle : allWinHandles) {
            if (!currentHandle.equals(handle)) {
                driver.switchTo().window(handle);
                if (driver.getCurrentUrl().startsWith(urlPrefix)) {
                    return;
                }
            }
        }
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
