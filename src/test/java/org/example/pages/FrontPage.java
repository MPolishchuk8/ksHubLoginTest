package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class FrontPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public FrontPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginBtn() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        button.click();
    }
}