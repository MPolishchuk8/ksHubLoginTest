package org.example;

import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.pages.ProfilePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

class LoginTest extends BaseTest {

    @Test
    void assertLoginSuccessWithCorrectCredentials() throws InterruptedException {
        open(Config.PRODUCT_URL);
        MainPage mainPage = new MainPage();
        mainPage.clickLoginBtn();
        switchToWindow(Config.PRODUCT_CAS_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin();
        loginPage.clickNextBtn();
        loginPage.inputPasswd();
        loginPage.clickNextBtn();
        switchToWindow(Config.PRODUCT_URL);
        Thread.sleep(1000);
        ProfilePage profilePage = new ProfilePage();
        String userName = profilePage.getUserName();
        Assertions.assertEquals(Config.USER_LOGIN, userName);
        profilePage.clickUserMenu();
        profilePage.userLogout();
    }
}
