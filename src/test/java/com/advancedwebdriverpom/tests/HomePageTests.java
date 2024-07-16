package com.advancedwebdriverpom.tests;

import com.advancedwebdriverpom.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This class contains the tests that we want to run against the home page. By creating an instance of HomePage,
// we are able to interact with the elements that we have stored in the HomePage class
public class HomePageTests {
    WebDriver driver;
    HomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        // The following two lines of code sets the window position for a multi-monitor setup
        // (-1920 = monitor to left of main, 1920 = monitor to right of main). Can be commented out if not needed.
        Point position = new Point(-1920, 0);
        driver.manage().window().setPosition(position);
        driver.manage().window().maximize();

    }

    @Test
    public void testYogaBlockElementsVisible() {
        assert homePage.getShopNewYogaButton().isDisplayed();
    }

    @Test
    public void testYogaClicksThroughToYogaPage(){
        homePage.getShopNewYogaButton().click();
        assert driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/collections/yoga-new.html");
    }
}
