package com.dilara.badretdinova;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChromeSettings {
  protected WebDriver driver;
  @Before
    public void setUp(){
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      driver = new ChromeDriver();
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
      driver.manage().window().maximize();
      driver.get(prop.getProperty("host"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
 // @After
   // public void tearDown(){
       // driver.quit();
  //}

}
