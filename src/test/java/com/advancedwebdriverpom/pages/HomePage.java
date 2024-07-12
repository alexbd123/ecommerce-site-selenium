package com.advancedwebdriverpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// This class contains the elements found on the Home page of the Luma eCommerce site https://magento.softwaretestingboard.com/
public class HomePage {
    WebDriver driver;
    WebElement shopNewYogaButton;
    WebElement yogaPromoBlock;
    WebElement pantsPromoBlock;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.shopNewYogaButton = driver.findElement(By.cssSelector(".action.more.button"));
        this.yogaPromoBlock = driver.findElement(By.cssSelector(".block-promo.home-main"));
        this.pantsPromoBlock = driver.findElement(By.cssSelector(".block-promo.home-pants"));
    }

    public WebElement getShopNewYogaButton() {
        return shopNewYogaButton;
    }

    public WebElement getYogaPromoBlock() {
        return yogaPromoBlock;
    }

    public WebElement getPantsPromoBlock() {
        return pantsPromoBlock;
    }

}
