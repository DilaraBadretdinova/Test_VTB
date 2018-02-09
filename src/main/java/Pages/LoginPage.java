package Pages;

import User.UserInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;
import java.util.concurrent.TimeUnit;

public class LoginPage extends Page {

    @FindBy(xpath = "//input[@type='text']")
    private WebElement login; //поле логин

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password; //поле пароль

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton; //кнопка Войти

    @FindBy(xpath = "//div[text()='BilalovaLR']")
    public WebElement userName; //кнопка Войти

    public MainPage clickLoginButton(UserInfo user) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        login.click();
        login.clear();
        login.sendKeys(user.getLogin());
        password.click();
        password.clear();
        password.sendKeys(user.getPassword());
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(userName));
        return new MainPage();

    }
public static byte[] takeScreenshot(){
    return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
}
}


