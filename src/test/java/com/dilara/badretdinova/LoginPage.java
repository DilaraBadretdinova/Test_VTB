package com.dilara.badretdinova;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {this.driver = driver;}
        public void assertLogin(){
            MainPage mainPage= new MainPage();
            PageFactory.initElements(driver, mainPage);
            FileInputStream fis;
            Properties prop = new Properties();
            try {
                fis = new FileInputStream("src/test/java/com/dilara/badretdinova/config.properties");
                prop.load(fis);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            mainPage.Login.click();
            mainPage.Login.clear();
            mainPage.Login.sendKeys(prop.getProperty("login"));}

        public void assertPassword() {
            MainPage mainPage= new MainPage();
            PageFactory.initElements(driver, mainPage);
            FileInputStream fis;
            Properties prop = new Properties();
            try {
                fis = new FileInputStream("src/test/java/com/dilara/badretdinova/config.properties");
                prop.load(fis);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            mainPage.Password.click();
            mainPage.Password.clear();
            mainPage.Password.sendKeys(prop.getProperty("password"));
}

    public  HomePage clickLoginButton(){
           MainPage mainPage= new MainPage();
         PageFactory.initElements(driver, mainPage);
         mainPage.loginButton.click();
        String User = mainPage.Name.getText();
        return new HomePage(driver);
}
  }
