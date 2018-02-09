package com.dilara.badretdinova;

import Pages.ConfigProperties;
import Pages.LoginPage;
import Pages.MainPage;
import User.UserInfo;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.Page;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
@Listeners(MyTestListener.class)
@Title("Кнопка 'Создать ПП'")
public class ButtonCreateNewPPTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context) {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        new LoginPage().clickLoginButton(user);
        context.setAttribute("app",MainPage.class);
    }

    @Title("Кнопка 'Создать ПП'")
    @Description("Проверка кнопки 'Создать ПП'")
    @Test
    public void clickButtonCreateNewPP() {
        new MainPage().clickCreateNewPP();
    }

    @AfterMethod
    public void updatePage() {
        driver = null;
    }
}
