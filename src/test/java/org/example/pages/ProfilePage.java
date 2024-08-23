package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private SelenideElement userMenu = $x("//*[contains(@title, 'login')]");
    private SelenideElement logoutBtn = $x("//*[contains(@href, '/auth/logout')]");

    public String getUserName() {
        return userMenu
                .shouldBe(Condition.visible)
                .getText();
    }

    public void clickUserMenu() {
        userMenu
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .click();
    }

    public void userLogout() {
        logoutBtn
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .click();
    }

}
