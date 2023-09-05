package com.saucedemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.Driver.getDriver;
import static org.junit.Assert.assertEquals;

public class InventoryPage {
    private By productsBuyFirstItemButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    public InventoryPage verifyThatInventoryPageIsOpened(String expectedUrl){
        String actualUrl = getDriver().getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
        return new InventoryPage();
    }

    public InventoryPage verifyThatProductsAreShown(String addToCartFirstItemNameButton){
        WebElement productAddToCartButton = getDriver().findElement(productsBuyFirstItemButton);
        String expectedBuyButtonText = productAddToCartButton.getAttribute("name");
        assertEquals(addToCartFirstItemNameButton, expectedBuyButtonText);
        return new InventoryPage();
    }
}
