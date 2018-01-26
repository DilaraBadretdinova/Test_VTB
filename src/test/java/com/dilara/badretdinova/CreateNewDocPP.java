package com.dilara.badretdinova;

import Pages.ConfigProperties;
import Pages.CreateNewPP;
import Pages.LoginPage;
import Pages.MainPage;
import User.UserInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Pages.Page;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CreateNewDocPP  {
    public WebDriver driver;
    private static Logger log = Logger.getLogger(CreateNewPP.class.getName());

    @Before
    public void setUp() {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
      UserInfo user = new UserInfo("1111111111", "1111111111");
      new LoginPage().clickLoginButton(user);
        new MainPage().clickCreateNewPP();

    }


    @Test
    public void verificationDocNumber() {
        CreateNewPP createNewPP = new CreateNewPP();
        //поле не пусто
        createNewPP.nonEmptyValueDocNumber();
        Assert.assertTrue("Поле пустое",createNewPP.number.getAttribute("value") != null);
        //в поле можно ввести цифры
        createNewPP.writeDocNumber();
        Assert.assertEquals("Не соответствует введенному значению","198", createNewPP.number.getAttribute("value"));
        //в поле можно нельзя ввести буквы
        createNewPP.writeLettersDocNumber();
        Assert.assertTrue("Записаны буквы", createNewPP.number.getAttribute("value")!= null);
       //ограничение в 15 символов
createNewPP.restrictionDocNumber();
        Assert.assertTrue("Требование ограничения длины не выполнено", createNewPP.number.getAttribute("value")!= "1111122222333334");
        log.info("Passed");
                }

    @Test
    public void verificationDocDate() {
        CreateNewPP createNewPP = new CreateNewPP();
        createNewPP.checkDocDate();

    }

    @Test
    public void verificationTemplate() {
        new Pages.CreateNewPP().checkTemplate();
    }

    @Test
    public void verificationTypePayment() {
        new Pages.CreateNewPP().checkTypePayment();
    }

    @Test
    public void verificationPriorityTypeOfPayment() {
        new Pages.CreateNewPP().checkPriorityOfPayment();
    }

    @Test
    public void verificationCodeEnter() {
        new Pages.CreateNewPP().checkCodeEnter();
            }

    @After
    public void updatePage() {
        driver = null;
}
}
