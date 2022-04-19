package com.anjukt.page.home;

import com.anjukt.page.AbstractPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**+
 * @author Anju Koshy
 */

public class HomePage extends AbstractPageObject {
    @FindBy(css = "a#login-dblue")
    private WebElement login;

    @Step
    public void clickLogin() {
        login.click();
    }

}
