package com.dilara.badretdinova;

import Pages.ConfigProperties;
import Pages.CreateNewPP;
import Pages.LoginPage;
import Pages.MainPage;
import User.UserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CreateNew extends CreateNewPP {
    @Before
    public void setUp() {
        getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        new LoginPage().clickLoginButton(user);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new MainPage().clickCreateNewPP();
    }

    @Test
    public void verificationDocNumber() {
        new CreateNewPP().checkDocNumber();
    }

    @Test
    public void verificationDocDate() {
        new CreateNewPP().checkDocDate();
    }

    @Test
    public void verificationTemplate() {
        new CreateNewPP().checkTemplate();
    }

    @Test
    public void verificationTypePayment() {
        new CreateNewPP().checkTypePayment();
    }

    @Test
    public void verificationPriorityTypeOfPayment() {
        new CreateNewPP().checkPriorityOfPayment();
    }

    @Test
    public void verificationCodeEnter() {
        new CreateNewPP().checkCodeEnter();
    }
//@After
//public void closePage(){
//    driver.quit();
    //  driver=null;
//}

}
