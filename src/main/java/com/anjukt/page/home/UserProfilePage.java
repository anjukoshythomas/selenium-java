package com.anjukt.page.home;

import com.anjukt.driver.DriverManager;
import com.anjukt.page.AbstractPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Path;
import java.nio.file.Paths;

/**+
 * @author Anju Koshy
 */

public class UserProfilePage extends AbstractPageObject {

    @FindBy(xpath = "//a//span[contains(text(),'test5678@test.com ')]")
    private WebElement username;

    @FindBy(xpath="//a[contains(text(),'Settings')]")
    private WebElement settings;

    @FindBy(xpath="//input[@id='user_avatar']")
    private WebElement chooseFile;

    @FindBy(name = "commit")
    private WebElement commit;

    @FindBy(xpath="//h3[contains(text(),'Your profile')]")
    private WebElement profileText;

    @Step
    public void clickUserProfile() {
        username.click();
    }

    @Step
    public void clickSettings() {
        settings.click();
    }

    @Step
    public void chooseFile() {
        WebElement upload_file = DriverManager.getDriver().findElement(By.id("user_avatar"));
        Path currentRelativePath = Paths.get("");
        String filePath = currentRelativePath.toAbsolutePath().toString();
        System.out.println(filePath);
        upload_file.sendKeys(filePath+"//src//test//resources//img.png");
    }

    @Step
    public void clickSubmit() {
        commit.click();
    }

    @Step
    public String verifyGetStartedTextAfterSignUp(){
        return profileText.getText();
    }

}
