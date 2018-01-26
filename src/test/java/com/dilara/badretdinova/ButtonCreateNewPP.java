package com.dilara.badretdinova;

import Pages.ConfigProperties;
import Pages.LoginPage;
import Pages.MainPage;
import User.UserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


//TODO Что за класс? Внутри у тебя тесты, классы тестов не экстендят страницы
public class ButtonCreateNewPP extends MainPage {
    @Before
    public void setUp() {
        getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        new LoginPage().clickLoginButton(user);

    }

    @Test
    public void clickButtonCreateNewPP() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new MainPage().clickCreateNewPP();
    }

    @After
    public void closePage() {
        driver.quit();
        driver = null;
    }
}
