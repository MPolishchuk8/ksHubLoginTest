package org.example.pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public void clickLoginBtn() {
        $("#login-button").shouldBe(clickable).click();
    }
}
