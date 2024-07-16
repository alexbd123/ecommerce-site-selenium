package com.advancedwebdriverpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainingPage {

    WebDriver driver;
    WebElement videoDownloadLink;
    WebElement backToHomeLink;
    WebElement goToVideosLink;
    WebElement erinRecommendsLink;

    public TrainingPage(WebDriver driver) {
        this.driver = driver;
        this.videoDownloadLink = driver.findElement(By.linkText("Video Download"));
        this.backToHomeLink = driver.findElement(By.linkText("Home"));
        this.goToVideosLink = driver.findElement(By.className("training-on-demand"));
        this.erinRecommendsLink = driver.findElement(By.className("training-erin"));
    }

    public WebElement getVideoDownloadLink() {
        return videoDownloadLink;
    }

    public WebElement getBackToHomeLink() {
        return backToHomeLink;
    }

    public WebElement getGoToVideosLink() {
        return goToVideosLink;
    }

    public WebElement getErinRecommendsLink() {
        return erinRecommendsLink;
    }
}
