package org.example;

import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.pages.ProfilePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginTest extends BaseTest {
    private final String login = System.getenv("LOGIN");
    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Test
    void loginTest() {
//      This test checks the possibility of entering the site by a user with a registered e-mail and password
        mainPage = new MainPage(driver);
        mainPage.clickLoginBtn();
        mainPage.switchToNewWindow();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.inputLogin();
        loginPage.clickNextBtn();
        loginPage.inputPasswd();
        loginPage.clickNextBtn();
        loginPage.switchToNewWindow();
        profilePage = new ProfilePage(driver);
        String user = profilePage.getUserName();
        Assertions.assertEquals(login, user);
        profilePage.clickUserMenu();
        profilePage.userLogout();
    }
}
