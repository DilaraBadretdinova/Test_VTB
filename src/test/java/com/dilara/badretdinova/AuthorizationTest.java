package com.dilara.badretdinova;

import Pages.CreateNewPP;
import Pages.LoginPage;

import User.UserInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import Pages.Page;
import Pages.ConfigProperties;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class AuthorizationTest {
    public WebDriver driver;
    private static Logger log = Logger.getLogger(AuthorizationTest.class.getName());

    @Before
    public void setUp() {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
    }

    @Test
    public void authorization() {
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton(user);
        Assert.assertEquals("BilalovaLR", loginPage.userName.getText());
        log.info("Passed");
    }

    @After
    public void UpdatePage() {
        driver = null;
    }
}


