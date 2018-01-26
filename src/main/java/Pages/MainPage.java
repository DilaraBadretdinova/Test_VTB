package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {
    @FindBy(xpath = "//div[text()='Создать ПП']")
    private WebElement createNewPP;

    public void clickCreateNewPP() {
        createNewPP.click();
    }
}

