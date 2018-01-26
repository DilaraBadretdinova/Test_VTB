package com.dilara.badretdinova;

import Pages.LoginPage;

import User.UserInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;


import Pages.ConfigProperties;
import org.junit.Test;


import java.util.concurrent.TimeUnit;

//TODO Что за класс? Внутри у тебя тесты, классы тестов не экстендят страницы
public class Authorization extends LoginPage {
    @Before
    public void setUp() {
        getDriver().get(ConfigProperties.getTestProperty("host"));
    }

    @Test
    public void authorization() {
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        new LoginPage().clickLoginButton(user);

        //TODO ImplicityWait не используем, где нужно ожидания используем ExplicityWait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("BilalovaLR", UserName.getText());
    }

    @After
    public void closePage() {

        //TODO Если будешь закрыавть driver после тест, то второй тест у тебя упадет
        driver.quit();
        driver = null;
    }
}

/*
public class TestVTB extends ChromeSettings {

    @Test
    public void verificationAuthorization() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
      loginPage.authorization();
        String User = loginPage.Name.getText();
        Assert.assertEquals("BilalovaLR", User);
    }

   @Test
   public void verificationHomePage(){
       LoginPage loginPage = new LoginPage(driver);
       PageFactory.initElements(driver, loginPage);
       loginPage.authorization();
       HomePage homePage = new HomePage(driver);
       PageFactory.initElements(driver, homePage);
       homePage.createNewPPButtonClick();
    }

    @Test
    public void verificationDocNumber()  {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        HomePage homePage = new HomePage(driver);
        PageFactory.initElements(driver, homePage);
        loginPage.authorization();
        homePage.createNewPPButtonClick();
        CreateNewPP createNewPP= new CreateNewPP(driver);
        PageFactory.initElements(driver, createNewPP);
        createNewPP.checkDocNumber(); //номер документ
    }

    @Test
    public void verificationDocDate()  {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        HomePage homePage = new HomePage(driver);
        PageFactory.initElements(driver, homePage);
        loginPage.authorization();
        homePage.createNewPPButtonClick();
        CreateNewPP createNewPP= new CreateNewPP(driver);
        PageFactory.initElements(driver, createNewPP);
        createNewPP.checkDocDate(); // дата документа}
    }

    @Test
    public void verificationTemplate()  {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        HomePage homePage = new HomePage(driver);
        PageFactory.initElements(driver, homePage);
        loginPage.authorization();
        homePage.createNewPPButtonClick();
        CreateNewPP createNewPP= new CreateNewPP(driver);
        PageFactory.initElements(driver, createNewPP);
        createNewPP.checkTemplate(); //шаблон
    }

    @Test
    public void verificationTypePayment()  {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        HomePage homePage = new HomePage(driver);
        PageFactory.initElements(driver, homePage);
        loginPage.authorization();
        homePage.createNewPPButtonClick();
        CreateNewPP createNewPP= new CreateNewPP(driver);
        PageFactory.initElements(driver, createNewPP);
    createNewPP.checkTypePayment(); //вид платежа
}
        @Test
        public void verificationPriorityOfPayment()  {
            LoginPage loginPage = new LoginPage(driver);
            PageFactory.initElements(driver, loginPage);
            HomePage homePage = new HomePage(driver);
            PageFactory.initElements(driver, homePage);
            loginPage.authorization();
            homePage.createNewPPButtonClick();
            CreateNewPP createNewPP= new CreateNewPP(driver);
            PageFactory.initElements(driver, createNewPP);
            createNewPP.checkPriorityOfPayment(); //очередность платежа
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test
        public void verificationCode()  {
            LoginPage loginPage = new LoginPage(driver);
            PageFactory.initElements(driver, loginPage);
            HomePage homePage = new HomePage(driver);
            PageFactory.initElements(driver, homePage);
            loginPage.authorization();
            homePage.createNewPPButtonClick();
            CreateNewPP createNewPP= new CreateNewPP(driver);
            PageFactory.initElements(driver, createNewPP);
            createNewPP.checkCodeEnter();//код
        }
    }*/



