package com.dilara.badretdinova;

import Pages.LoginPage;

import User.UserInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import Pages.Page;
import Pages.ConfigProperties;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Authorization  {
   public WebDriver driver;

    @Before
    public void setUp() {
        new Page(). getDriver().get(ConfigProperties.getTestProperty("host"));
    }

    @Test
    public void authorization() {
        UserInfo user = new UserInfo(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton(user);
        Assert.assertEquals("BilalovaLR", loginPage.userName.getText());
        System.out.println("Passed");
          }

    @After
    public void UpdatePage() {
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



