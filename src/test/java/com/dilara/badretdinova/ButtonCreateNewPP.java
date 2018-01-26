package com.dilara.badretdinova;

import Pages.ConfigProperties;
import Pages.LoginPage;
import Pages.MainPage;
import User.UserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Pages.Page;
import org.openqa.selenium.WebDriver;


<<<<<<< HEAD
public class ButtonCreateNewPP  {
    public WebDriver driver;
=======

//TODO Что за класс? Внутри у тебя тесты, классы тестов не экстендят страницы
public class ButtonCreateNewPP extends MainPage {
>>>>>>> a0cd9bca1981506964e3667bb47195bd0d27ab04
    @Before
    public void setUp() {
        new Page() .getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        new LoginPage().clickLoginButton(user);
    }

    @Test
    public void clickButtonCreateNewPP() {
         new MainPage().clickCreateNewPP();
    }

    @After
    public void updatePage() {
           driver = null;
    }
}
