package org.example;

import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.pages.ProfilePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

class LoginTest extends BaseTest {

    @Test
    void assertLoginSuccessWithCorrectCredentials() {
        open(Config.PRODUCT_URL);
        MainPage mainPage = new MainPage();
        mainPage.clickLoginBtn();
        switchToNextWindow();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin();
        loginPage.clickNextBtn();
        loginPage.inputPasswd();
        loginPage.clickNextBtn();
        switchToNextWindow();
        ProfilePage profilePage = new ProfilePage();
        String user = profilePage.getUserName();
        Assertions.assertEquals(Config.USER_LOGIN, user);
        profilePage.clickUserMenu();
        profilePage.userLogout();
    }
}
