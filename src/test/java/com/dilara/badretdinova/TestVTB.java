package com.dilara.badretdinova;
import org.junit.*;
import org.openqa.selenium.support.PageFactory;

public class TestVTB extends ChromeSettings {
    @Test
   public  void authorization() throws InterruptedException {
       MainPage mainPage= new MainPage();
       PageFactory.initElements(driver, mainPage);
      LoginPage loginPage= new LoginPage(driver);
      loginPage.assertLogin();
      loginPage.assertPassword();
      HomePage resultpage = loginPage.clickLoginButton();
     String User = mainPage.Name.getText();
     Assert.assertEquals("BilalovaLR", User);
   //}

//@Test
  // public void homePage() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    CreateNewPP createNewPP = homePage.createNewPPButton();
    createNewPP.docNumber(); //номер документа
    createNewPP.docDate(); // дата документа
     createNewPP.template(); //шаблон
    createNewPP.payment(); //вид платежа

    }

}

