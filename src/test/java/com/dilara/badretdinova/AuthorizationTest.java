package com.dilara.badretdinova;

import Pages.LoginPage;

import User.UserInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.Page;
import Pages.ConfigProperties;

import org.openqa.selenium.WebDriver;


import ru.yandex.qatools.allure.annotations.Description;

import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.logging.Logger;
@Listeners(MyTestListener.class)

@Title("Вход")

public class AuthorizationTest {
    public WebDriver driver;
    private static Logger log = Logger.getLogger(AuthorizationTest.class.getName());

    @BeforeMethod
    public void setUp(ITestContext context) {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
       context.setAttribute("app",LoginPage.class);
    }

    @Title("Страница авторизации")
    @Description("Ввод логина и пароля на странице авторизации")
    @Test

    public void authorization() throws IOException {
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton(user);
        Assert.assertEquals("BilalovLR", loginPage.userName.getText());
        log.info("Passed");

    }

      @AfterMethod
        public void UpdatePage() {
          driver = null;
        }
    }


