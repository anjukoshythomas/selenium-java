package com.anjukt.test;

import com.anjukt.BaseWeb;
import com.anjukt.data.DataFactory;
import com.anjukt.model.TestData;
import com.anjukt.page.home.LoginPage;
import com.anjukt.page.home.SignUpPage;
import com.anjukt.page.home.UserProfilePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginWebTest  extends BaseWeb {
 static String EMAIL;
 static String PASSWORD;

 @BeforeTest
 public void generateUser(){
     TestData bookingInformation = new DataFactory().createBookingData();
     EMAIL=bookingInformation.getEmail();
     PASSWORD=bookingInformation.getPassword();
 }

   @Test(description = "Click Signup CloudApp", priority = 0)
    public void SignInApp(){
        LoginPage loginPage=new LoginPage();
        loginPage.clickSignUp();
       assertThat(loginPage.verifyGetStartedTextAfterSignUp())
               .isEqualTo("Get started");
    }

   @Test(description = "Signup CloudApp as new user",priority = 1)
    public void SignAppAsNewUser(){
        LoginPage loginPage=new LoginPage();
        loginPage.clickSignUp();
        SignUpPage signUpPage=new SignUpPage();
        signUpPage.fillEmail(EMAIL);
        signUpPage.fillPassword(PASSWORD);
        signUpPage.clickSignIn();
        assertThat(signUpPage.verifyTextAfterSignUp())
                .isEqualTo("Desktop App");
    }

    @Test(description = "SignIn CloudApp as existing user and update Avatar", priority = 2)
    public void SignAppAsExistingUser(){
        String encodedString="VGVzdHVzZXIxMjMj";
        LoginPage loginPage=new LoginPage();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        loginPage.fillEmail("test5678@test.com");
        loginPage.fillPassword(decodedString);
        loginPage.clickSignIn();
        assertThat(loginPage.verifyWelcomeText()).isEqualTo("Welcome back!");

        UserProfilePage userPage=new UserProfilePage();
        userPage.clickUserProfile();
        userPage.clickSettings();
        userPage.chooseFile();
        userPage.clickSubmit();
        assertThat(userPage.verifyGetStartedTextAfterSignUp())
                .isEqualTo("Your profile");
    }


}
