package com.dilara.badretdinova;

import Pages.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import User.UserInfo;
import Pages.DeleteMessageForBank;

import java.util.logging.Logger;


public class DeleteMessages {
    public WebDriver driver;
    private static Logger log = Logger.getLogger(DeleteMessageForBank.class.getName());

    @Before
    public void setUp() {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo("1111111111", "1111111111");
        new LoginPage().clickLoginButton(user);
        new MainPage().clickCreateNewPP();

    }
//отмена/удаление
    @Test
    public void cancleDeleteMessage() {
        DeleteMessageForBank deleteMessageForBank = new DeleteMessageForBank();
        deleteMessageForBank.cancleDeleteMessageForBank();
    }

}
