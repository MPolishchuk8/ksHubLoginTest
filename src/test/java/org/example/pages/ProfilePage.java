/* package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

//    @FindBy(xpath = "//*[contains(@class, 'UserProfileContainer_subButton__loxWR')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'UserProfileContainer_link__biHuo')]")
    private WebElement logoutBtn;

    public String getUserName() {
        String userName = userMenu.getText();
        return userName;
    }

    public void userMenu() {
        WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        userMenu.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }
} */
package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class, 'UserProfileContainer_subButton__loxWR')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'UserProfileContainer_link__biHuo')]")
    private WebElement logoutBtn;

    public String getUserName() {
        wait.until(ExpectedConditions.visibilityOf(userMenu));
        return userMenu.getText();
    }

    public void clickUserMenu() {
        WebElement userMenuButton = wait.until(ExpectedConditions.elementToBeClickable(userMenu));
        userMenuButton.click();
    }

    public void userLogout() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutButton.click();
    }
}
