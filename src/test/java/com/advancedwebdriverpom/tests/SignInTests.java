package com.advancedwebdriverpom.tests;


import com.advancedwebdriverpom.pages.SignInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SignInTests {

    WebDriver driver;
    SignInPage signInPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        signInPage = new SignInPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSignInTakesUserToHomepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        signInPage.submitValidLogin();
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/"));
        assert driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void testSuccessfulSignInDisplaysCorrectMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        signInPage.submitValidLogin();
        wait.until(ExpectedConditions.textToBe(By.className("greet"), "Welcome, Alex Berridge-Dunn!"));
        assert driver.findElement(By.className("greet")).getText().equals("Welcome, Alex Berridge-Dunn!");
    }

    @Test
    public void testInvalidSignInDisplaysCorrectMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

        signInPage.submitInvalidLogin();
        wait.until(ExpectedConditions.textToBe(By.className("message-error"), expectedText));
        assert driver.findElement(By.className("message-error")).getText().equals(expectedText);

    }

    @Test
    public void testForgotYourPasswordLinkClicksThroughToCorrectPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/forgotpassword/";

        signInPage.getForgotYourPasswordLink().click();
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        assert driver.getCurrentUrl().equals(expectedURL);
    }

    @Test
    public void testInvalidEmailPromptsWarning() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String warningText = "Please enter a valid email address (Ex: johndoe@domain.com).";

        signInPage.submitInvalidEmail();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email-error")));
        WebElement warningTextElement = driver.findElement(By.cssSelector("#email-error"));
        assert warningTextElement.getText().equals(warningText);
    }

    @Test
    public void testOnlyEnteringPasswordPromptsWarning() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String warningText = "This is a required field.";

        signInPage.onlySubmitPassword();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email-error")));
        WebElement warningTextElement = driver.findElement(By.cssSelector("#email-error"));
        assert warningTextElement.getText().equals(warningText);
    }

    @Test
    public void testOnlyEnteringEmailPromptsWarning() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        String warningText = "This is a required field.";

        signInPage.onlySubmitValidEmail();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pass-error")));
        WebElement warningTextElement = driver.findElement(By.cssSelector("#pass-error"));
        assert warningTextElement.getText().equals(warningText);
    }

    @Test
    public void testClickingOnCreateAccountClicksThroughToCorrectPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/create/";

        signInPage.clickOnCreateAccountButton();
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        assert driver.getCurrentUrl().equals(expectedURL);
    }
}
