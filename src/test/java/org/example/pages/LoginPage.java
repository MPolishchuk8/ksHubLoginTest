package org.example.pages;

import com.codeborne.selenide.Condition;
import org.example.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void inputLogin() {
        $(By.xpath("//*[@data-testid='login-input']"))
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .setValue(Config.USER_LOGIN);
    }

    public void inputPasswd() {
        $(By.xpath("//*[@data-testid='password-input']"))
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .setValue(Config.USER_PASSWORD);
    }

    public void clickNextBtn() {
        $(By.xpath("//*[@data-testid='next-button']"))
                .shouldBe(Condition.clickable)
                .click();
    }
}
