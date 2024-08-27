package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {

    public ProfilePage(WebDriver driver) {
    }

    private final SelenideElement userMenu = $x("//button[@id='login-button']");
    private final SelenideElement logoutBtn = $x("//a[@href = '/auth/logout']");

    public String getUserName() {
        return userMenu
                .should(Condition.exist)
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .getText();
    }

    public void clickUserMenu() {
        userMenu
                .should(Condition.exist)
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .click();
    }

    public void userLogout() {
        logoutBtn
                .should(Condition.exist)
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .click();
    }
}
