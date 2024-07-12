package com.advancedwebdriverpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemDetailPage {

    WebDriver driver;
    List<WebElement> sizes;
    List<WebElement> colours;
    WebElement addToCartButton;
    String itemPrice;

    // This class contains common elements found on the item detail page (when selecting a specific item of clothing)
    public ItemDetailPage(WebDriver driver) {
        this.driver = driver;
        this.sizes = driver.findElements(By.cssSelector(".swatch-option.text"));
        this.colours = driver.findElements(By.cssSelector(".swatch-option.color"));
        this.addToCartButton = driver.findElement(By.id("product-addtocart-button"));
        this.itemPrice = driver.findElement(By.className("price")).getText();
    }

    public WebElement getFirstSize() {
        return sizes.getFirst();
    }
    public WebElement getLastSize() {
        return sizes.getLast();
    }
    public WebElement getFirstColour() {
        return colours.getFirst();
    }
    public WebElement getLastColour() {
        return colours.getLast();
    }
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    public String getItemPrice() {
        return itemPrice;
    }
}
