package com.advancedwebdriverpom.actions;

import com.advancedwebdriverpom.pages.SignInPage;
import org.openqa.selenium.WebDriver;

public class SignInPageActions {

    WebDriver driver;
    SignInPage signInPage;

    public SignInPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void submitValidLogin() {
        signInPage = new SignInPage(driver);
        signInPage.getEmailInput().sendKeys(signInPage.validEmail);
        signInPage.getPasswordInput().sendKeys(signInPage.validPassword);
        signInPage.getSignInButton().click();
    }

    public void submitInvalidLogin() {
        signInPage = new SignInPage(driver);
        signInPage.getEmailInput().sendKeys(signInPage.emailNotLinkedToAccount);
        signInPage.getPasswordInput().sendKeys(signInPage.invalidPassword);
        signInPage.getSignInButton().click();
    }

    public void submitInvalidEmail() {
        signInPage = new SignInPage(driver);
        signInPage.getEmailInput().sendKeys(signInPage.invalidEmail);
        signInPage.getSignInButton().click();
    }

    public void onlySubmitPassword() {
        signInPage = new SignInPage(driver);
        signInPage.getPasswordInput().sendKeys(signInPage.invalidPassword);
        signInPage.getSignInButton().click();
    }

    public void onlySubmitValidEmail() {
        signInPage = new SignInPage(driver);
        signInPage.getEmailInput().sendKeys(signInPage.validEmail);
        signInPage.getSignInButton().click();
    }

    public void clickOnCreateAccountButton() {
        signInPage = new SignInPage(driver);
        signInPage.getCreateAnAccountButton().click();
    }

}
