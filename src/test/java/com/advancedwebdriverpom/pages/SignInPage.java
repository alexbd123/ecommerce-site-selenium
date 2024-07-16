package com.advancedwebdriverpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    WebDriver driver;
    WebElement emailInput;
    WebElement passwordInput;
    WebElement signInButton;
    WebElement forgotYourPasswordLink;
    WebElement createAnAccountButton;

    String validEmail = "alexpjbd@gmail.com";
    String validPassword = "pc63ajt_pzCDcD#";
    String emailNotLinkedToAccount = "scoobydoo@whereareyou.com";
    String invalidPassword = "scooby-snacks";
    String invalidEmail = "googoo";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.emailInput = driver.findElement(By.name("login[username]"));
        this.passwordInput = driver.findElement(By.name("login[password]"));
        this.signInButton = driver.findElement(By.cssSelector("#send2"));
        this.forgotYourPasswordLink = driver.findElement(By.linkText("Forgot Your Password?"));
        this.createAnAccountButton = driver.findElement(By.linkText("Create an Account"));
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getForgotYourPasswordLink() {
        return forgotYourPasswordLink;
    }

    public WebElement getCreateAnAccountButton() {
        return createAnAccountButton;
    }

    public void submitValidLogin() {
        getEmailInput().sendKeys(validEmail);
        getPasswordInput().sendKeys(validPassword);
        getSignInButton().click();
    }

    public void submitInvalidLogin() {
        getEmailInput().sendKeys(emailNotLinkedToAccount);
        getPasswordInput().sendKeys(invalidPassword);
        getSignInButton().click();
    }

    public void submitInvalidEmail() {
        getEmailInput().sendKeys(invalidEmail);
        getSignInButton().click();
    }

    public void onlySubmitPassword() {
        getPasswordInput().sendKeys(invalidPassword);
        getSignInButton().click();
    }

    public void onlySubmitValidEmail() {
        getEmailInput().sendKeys(validEmail);
        getSignInButton().click();
    }

    public void clickOnCreateAccountButton() {
        getCreateAnAccountButton().click();
    }
}
