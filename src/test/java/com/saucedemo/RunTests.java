package com.saucedemo;

import core.Driver;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.saucedemo.PageObjects.StartPage;

public class RunTests {

    private String mainPageUrl = "https://www.saucedemo.com";
    private String username = "standard_user";
    private String password = "secret_sauce";
    private String passwordType = "password";
    private String inventoryPageUrl = "https://www.saucedemo.com/inventory.html";
    private String buyFirstItemButtonName = "add-to-cart-sauce-labs-backpack";

    @Before
    public void basicConfigure() {
        BasicConfigurator.configure();
    }
    @After
    public void killDriver() {
        Driver.kill();
    }

    @Test
    public void firstTest() {
        new StartPage()
                .navigateTo(mainPageUrl)
                .enterUsername(username)
                .verifyThatEnteredUsernameIs(username)
                .enterPassword(password)
                .verifyThatEnteredPasswordIsRepresentedAsDots(password, passwordType)
                .pressLoginButton()
                .verifyThatInventoryPageIsOpened(inventoryPageUrl)
                .verifyThatProductsAreShown(buyFirstItemButtonName);
    }
}
