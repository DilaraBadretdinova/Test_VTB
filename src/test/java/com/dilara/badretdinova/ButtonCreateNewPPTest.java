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
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

@Title("Кнопка 'Создать ПП'")
public class ButtonCreateNewPPTest {
    public WebDriver driver;

    @Before
    public void setUp() {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        new LoginPage().clickLoginButton(user);
    }

    @Title("Кнопка 'Создать ПП'")
    @Description("Проверка кнопки 'Создать ПП'")
    @Test
    public void clickButtonCreateNewPP() {
        new MainPage().clickCreateNewPP();
    }

    @After
    public void updatePage() {
        driver = null;
    }
}
