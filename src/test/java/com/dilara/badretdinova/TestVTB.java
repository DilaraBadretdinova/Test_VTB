package com.dilara.badretdinova;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import static jdk.jfr.internal.SecuritySupport.getResourceAsStream;

public class TestVTB {
    private static ChromeDriver webDriver;
    MainPage mainPage;


    @Before
        public  void setUp() {
       System.setProperty("webdriver.chrome.driver", "C://Program Files//chromedriver.exe");
        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);
    }

   @Test
   public  void Payment() {
        mainPage.open();
        mainPage.newPP();
        mainPage.dateDoc();
        mainPage.template();
        mainPage.payment();
    }


@After
    public void tearDown(){
            if (webDriver != null) webDriver.quit();
}
}

