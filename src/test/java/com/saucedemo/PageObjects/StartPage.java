package com.saucedemo.PageObjects;

import core.Driver;

public class StartPage {

    public MainPage navigateTo(String url) {
        Driver.getDriver().get(url);
        return new MainPage();
    }
}
