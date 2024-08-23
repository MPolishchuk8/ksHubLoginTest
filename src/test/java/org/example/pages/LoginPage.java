package org.example.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public WebDriver driver;
    private final String LOGIN = System.getenv("LOGIN");
    private final String PASSWORD = System.getenv("PASSWORD");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputLogin() {
        $(By.xpath("//*[@data-testid='login-input']"))
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .setValue(LOGIN);
    }

    public void inputPasswd() {
        $(By.xpath("//*[@data-testid='password-input']"))
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .setValue(PASSWORD);
    }

    public void clickNextBtn() {
        $(By.xpath("//*[@data-testid='next-button']"))
                .shouldBe(Condition.clickable)
                .click();
    }

    public void switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                if ($(By.xpath("//*[@data-testid='login-input']")).exists()) break;
            }
        }
    }

}
