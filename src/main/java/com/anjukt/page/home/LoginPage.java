package com.anjukt.page.home;

import com.anjukt.page.AbstractPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageObject {
    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement commit;

    @FindBy(xpath = "//a[contains(text(),'Sign up for free')]")
    private WebElement signup;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signin;

    @FindBy(xpath = "//div[contains(text(),'Welcome back!')]")
    private WebElement verifyWelcomeText;

    @Step
    public void clickSignUp() {
        signup.click();
    }

    @Step
    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    @Step
    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    @Step
    public void clickSignIn() {
        commit.click();
    }

    @Step
    public void clickSignInLink(){
        signin.click();
    }

    @Step
    public String verifyWelcomeText(){
        return verifyWelcomeText.getText();
    }

}
