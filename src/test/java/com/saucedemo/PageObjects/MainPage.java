package com.saucedemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static core.Driver.getDriver;

public class MainPage {
    private By usernameInputField = By.xpath("//input[@id='user-name']");
    private By passwordInputField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");


    public MainPage enterUsername(String username) {
        WebElement usernameInputFieldElement = getDriver().findElement(usernameInputField);
        usernameInputFieldElement.sendKeys(username);
        return new MainPage();
    }

    public MainPage verifyThatEnteredUsernameIs(String expectedUsername) {
        WebElement usernameInputFieldElement = getDriver().findElement(usernameInputField);
        String actualUsername = usernameInputFieldElement.getAttribute("value");
        assertEquals(expectedUsername, actualUsername);
        return new MainPage();
    }

    public MainPage enterPassword(String password) {
        WebElement passwordInputFieldElement = getDriver().findElement(passwordInputField);
        passwordInputFieldElement.sendKeys(password);
        return new MainPage();
    }

    public MainPage verifyThatEnteredPasswordIsRepresentedAsDots(String expectedPassword, String passwordByDots){
        WebElement passwordInputFieldElement = getDriver().findElement(passwordInputField);
        String actualPassword = passwordInputFieldElement.getAttribute("value");
        assertEquals(expectedPassword, actualPassword);

        String actualPasswordIsEnteredByDots = passwordInputFieldElement.getAttribute("type");
        assertEquals(passwordByDots, actualPasswordIsEnteredByDots);
        return new MainPage();
    }

    public InventoryPage pressLoginButton() {
        WebElement loginButtonElement = getDriver().findElement(loginButton);
        loginButtonElement.click();
        return new InventoryPage();
    }
}
