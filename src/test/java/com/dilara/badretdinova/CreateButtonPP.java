package com.dilara.badretdinova;

import Pages.ConfigProperties;
import Pages.LoginPage;
import Pages.MainPage;
import User.UserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CreateButtonPP extends MainPage {
    @Before
            public void setUp(){
    getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo("1111111111", "1111111111");
        new LoginPage().clickLoginButton(user);

    }
    @Test
    public void clickButtonCreateNewPP() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         new MainPage() .clickCreateNewPP();
    }
    @After
    public void closePage(){
        driver.quit();
        driver=null;
    }
}
