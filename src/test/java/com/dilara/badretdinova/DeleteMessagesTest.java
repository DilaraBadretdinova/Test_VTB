package com.dilara.badretdinova;

import Pages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import User.UserInfo;
import Pages.DeleteMessageForBank;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.logging.Logger;

@Title("Удаление сообщения из справочника")
public class DeleteMessagesTest {
    public WebDriver driver;
    private static Logger log = Logger.getLogger(DeleteMessagesTest.class.getName());

    @Before
    public void setUp() {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo("1111111111", "1111111111");
        new LoginPage().clickLoginButton(user);
        new MainPage().clickCreateNewPP();

    }

    //удаление
    @Title("Удаление сообщения из справочника")
    @Description("Создать новое сообщение, затем отменить удаление и удалить")
    @Test
    public void deleteMessage() {
        DeleteMessageForBank deleteMessageForBank = new DeleteMessageForBank();
        deleteMessageForBank.deleteMessageForBank();
    }
}
