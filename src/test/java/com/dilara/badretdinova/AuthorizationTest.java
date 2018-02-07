package com.dilara.badretdinova;

import Pages.CreateNewPP;
import Pages.LoginPage;

import User.UserInfo;

import org.junit.*;

import Pages.Page;
import Pages.ConfigProperties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@Title("Вход")

public class AuthorizationTest {
    public WebDriver driver;


    private static Logger log = Logger.getLogger(AuthorizationTest.class.getName());

    @Before
    public void setUp() {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
    }

    @Title("Страница авторизации")
    @Description("Ввод логина и пароля на странице авторизации")
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


