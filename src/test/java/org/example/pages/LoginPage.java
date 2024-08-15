package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Продовжити')]")
    private WebElement loginBtn;

    public void inputLogin(String login) {
        WebElement loginField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@data-testid, 'login-input')]")));
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        WebElement passwdField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@data-testid, 'password-input')]")));
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
