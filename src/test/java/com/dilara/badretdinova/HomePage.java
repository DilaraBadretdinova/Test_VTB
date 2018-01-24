package com.dilara.badretdinova;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){this.driver = driver; }

    public CreateNewPP createNewPPButton(){
        MainPage mainPage= new MainPage();
        PageFactory.initElements(driver, mainPage);
        mainPage.NewPPButton.click();
        return new CreateNewPP(driver);
    }

}
