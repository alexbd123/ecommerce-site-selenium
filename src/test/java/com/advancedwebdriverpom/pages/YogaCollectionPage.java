package com.advancedwebdriverpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YogaCollectionPage {
    WebDriver driver;
    WebElement firstYogaClothingItem;

    // This class contains the elements found on the Yoga collection products page
    public YogaCollectionPage(WebDriver driver) {
        this.driver = driver;
        this.firstYogaClothingItem = driver.findElement(By.className("product-item-info"));
    }

    public WebElement getFirstYogaClothingItem() {
        return firstYogaClothingItem;
    }




}
