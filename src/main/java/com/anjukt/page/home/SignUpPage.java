package com.anjukt.page.home;

import com.anjukt.page.AbstractPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**+
 * @author Anju Koshy
 */

public class SignUpPage extends AbstractPageObject {
    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement commit;

    @FindBy(xpath = "//p[contains(text(),'Desktop App')]")
    private WebElement verifyText;

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
    public String verifyTextAfterSignUp(){
       return verifyText.getText();
    }

}
