package com.advancedwebdriverpom.actions;

import com.advancedwebdriverpom.pages.ItemDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// This class contains common actions ('methods') that can be used on the individual items details page
// e.g. when selecting a specific item of clothing
public class ItemPageActions {
    WebDriver driver;
    ItemDetailPage itemDetailPage;

    public ItemPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void AddItemToCartByFirstSizeAndColour() {
        itemDetailPage = new ItemDetailPage(driver);
        //click first size option, first colour option and 'Add to Cart'
        itemDetailPage.getFirstSize().click();
        itemDetailPage.getFirstColour().click();
        itemDetailPage.getAddToCartButton().click();
        cartItemAddedChecker();
    }

    public void AddItemToCartByLastSizeAndColour() {
        itemDetailPage = new ItemDetailPage(driver);
        //click first size option, first colour option and 'Add to Cart'
        itemDetailPage.getLastSize().click();
        itemDetailPage.getLastColour().click();
        itemDetailPage.getAddToCartButton().click();
        cartItemAddedChecker();
    }

    public void AddSpecificNumberOfItemsToCartByFirstSizeAndColour(String quantity) {
        itemDetailPage = new ItemDetailPage(driver);
        //click first size option, first colour option and 'Add to Cart'
        itemDetailPage.getFirstSize().click();
        itemDetailPage.getFirstColour().click();
        setItemQuantity(quantity);
        itemDetailPage.getAddToCartButton().click();
        cartItemAddedChecker();
    }


    public void cartItemAddedChecker(){
        long startTime = System.currentTimeMillis();
        String cartItemCount = driver.findElement(By.className("counter-number")).getText();
        //Keep checking for the cart counter number of the cart to change for max 10 seconds.
        while (cartItemCount.equals(driver.findElement(By.className("counter-number")).getText())) {
            if (System.currentTimeMillis() - startTime > 10000) {
                System.out.println("Failed to add item to cart");
                assert false;
                }
        }
        System.out.println("Items in shopping cart = " + driver.findElement(By.className("counter-number")).getText());
        assert (Integer.parseInt(driver.findElement(By.className("counter-number")).getText())) > 0;
    }

    public void setItemQuantity(String qty){
        WebElement itemQuantity = driver.findElement(By.id("qty"));
        itemQuantity.clear();
        itemQuantity.sendKeys(qty);
    }
}
