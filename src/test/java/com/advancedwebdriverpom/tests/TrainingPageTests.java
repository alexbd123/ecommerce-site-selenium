package com.advancedwebdriverpom.tests;

import com.advancedwebdriverpom.pages.TrainingPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TrainingPageTests {

    WebDriver driver;
    TrainingPage trainingPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/training.html");
        trainingPage = new TrainingPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testVideoDownloadLinkIsVisible() {
        assert trainingPage.getVideoDownloadLink().isDisplayed();
    }

    @Test
    public void testVideoDownloadLinkClicksThroughToVideoDownloadPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        trainingPage.getVideoDownloadLink().click();
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/training/training-video.html"));
        assert driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/training/training-video.html");
    }

    @Test
    public void testBackToHomeLinkIsVisible() {
        assert trainingPage.getBackToHomeLink().isDisplayed();
    }

    @Test
    public void testBackToHomeLinkClicksThroughToHomepage() {
        trainingPage.getBackToHomeLink().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/"));
        assert driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void testGoToVideosLinkIsVisible() {
        assert trainingPage.getGoToVideosLink().isDisplayed();
    }

    @Test
    public void testGoToVideosLinkClicksThroughToVideoPage() {
        trainingPage.getGoToVideosLink().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/training/training-video.html"));
        assert driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/training/training-video.html");
    }

    @Test
    public void testErinRecommendsLinkIsVisible() {
        assert trainingPage.getErinRecommendsLink().isDisplayed();
    }

    @Test
    public void testErinRecommendsLinkClicksThroughToErinRecommendsPage() {
        trainingPage.getErinRecommendsLink().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/collections/erin-recommends.html"));
        assert driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/collections/erin-recommends.html");
    }
}
