package com.advancedwebdriverpom.tests;

import com.advancedwebdriverpom.actions.ItemPageActions;
import com.advancedwebdriverpom.pages.CartPopup;
import com.advancedwebdriverpom.pages.HomePage;
import com.advancedwebdriverpom.pages.ItemDetailPage;
import com.advancedwebdriverpom.pages.YogaCollectionPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CartTests {
    WebDriver driver;
    HomePage homePage;
    YogaCollectionPage yogaCollectionPage;
    CartPopup cartPopup;
    ItemPageActions cartActions;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // The following two lines of code sets the window position for a multi-monitor setup
        // (-1920 = monitor to left of main, 1920 = monitor to right of main). Can be commented out if not needed.
        Point position = new Point(-1920, 0);
        driver.manage().window().setPosition(position);
        driver.manage().window().maximize();

    }
    @Test
    public void addYogaItemToCartByFirstSizeAndColour(){
        homePage.getShopNewYogaButton().click();
        yogaCollectionPage = new YogaCollectionPage(driver);
        yogaCollectionPage.getFirstYogaClothingItem().click();
        cartActions = new ItemPageActions(driver);
        cartActions.AddItemToCartByFirstSizeAndColour();
    }

    @Test
    public void addItemToCartAndCheckSubtotalAgainstItemPrice(){
        homePage.getShopNewYogaButton().click();
        yogaCollectionPage = new YogaCollectionPage(driver);
        yogaCollectionPage.getFirstYogaClothingItem().click();
        cartActions = new ItemPageActions(driver);
        cartActions.AddItemToCartByFirstSizeAndColour();
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        String itemPrice = itemDetailPage.getItemPrice();
        System.out.println("Item Price = " + itemPrice);
        makeCartPopupVisible();
        cartPopup = new CartPopup(driver);
        System.out.println("Cart Subtotal = " + cartPopup.getCartSubtotal());
        assert cartPopup.getCartSubtotal().equals(itemPrice);
    }

    @Test
    public void addYogaItemToCartByLastSizeAndColour(){
        homePage.getShopNewYogaButton().click();
        yogaCollectionPage = new YogaCollectionPage(driver);
        yogaCollectionPage.getFirstYogaClothingItem().click();
        cartActions = new ItemPageActions(driver);
        cartActions.AddItemToCartByLastSizeAndColour();
    }

    @Test
    public void addFourYogaItemsToCartByFirstSizeAndColour(){
        homePage.getShopNewYogaButton().click();
        yogaCollectionPage = new YogaCollectionPage(driver);
        yogaCollectionPage.getFirstYogaClothingItem().click();
        cartActions = new ItemPageActions(driver);
        cartActions.AddSpecificNumberOfItemsToCartByFirstSizeAndColour("4");
    }
    @Test
    public void checkCartPopupIsVisible(){
        makeCartPopupVisible();
        cartPopup = new CartPopup(driver);
        assert cartPopup.getCartPopupModal().isDisplayed();
    }


    public void makeCartPopupVisible(){
        driver.findElement(By.cssSelector(".action.showcart")).click();
    }

}
