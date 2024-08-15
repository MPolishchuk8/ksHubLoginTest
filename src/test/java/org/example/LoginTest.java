package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginTest extends BaseTest {

    @Test
    void loginTest() {
        frontPage.clickLoginBtn();
        switchToNewWindow();
        driver.manage().window().maximize();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        switchToNewWindow();
        String user = profilePage.getUserName();
        Assertions.assertEquals(ConfProperties.getProperty("login"), user);
    }
}
