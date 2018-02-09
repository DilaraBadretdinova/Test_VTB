package com.dilara.badretdinova;

import Pages.*;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import User.UserInfo;
import Pages.DeleteMessageForBank;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.logging.Logger;
@Listeners(MyTestListener.class)
@Title("Удаление сообщения из справочника")
public class DeleteMessagesTest {
    public WebDriver driver;
    private static Logger log = Logger.getLogger(DeleteMessagesTest.class.getName());

    @BeforeMethod
    public void setUp(ITestContext context) {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo("1111111111", "1111111111");
        new LoginPage().clickLoginButton(user);
        new MainPage().clickCreateNewPP();
        context.setAttribute("app",DeleteMessageForBank.class);
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
