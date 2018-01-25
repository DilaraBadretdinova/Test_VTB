package com.dilara.badretdinova;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){this.driver = driver; }

    @FindBy(xpath = "//div[text()='Создать ПП']")
    WebElement NewPPButton; //кнопка Создать ПП

    public CreateNewPP createNewPPButtonClick(){
        NewPPButton.click();
        return new CreateNewPP(driver);
    }

}
