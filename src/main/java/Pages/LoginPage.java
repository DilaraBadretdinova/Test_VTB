package Pages;

import User.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
=======
//TODO Поля пишутся с малеькой буквы, классы с большой
>>>>>>> a0cd9bca1981506964e3667bb47195bd0d27ab04

import java.util.concurrent.TimeUnit;

public class LoginPage extends Page {
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        @FindBy(xpath = "//input[@type='text']")
        private WebElement login; //поле логин
        @FindBy(xpath = "//input[@type='password']")
        private WebElement password; //поле пароль
        @FindBy(xpath = "//button[text()='Войти']")
        private WebElement loginButton; //кнопка Войти
       @FindBy(xpath = "//div[text()='BilalovaLR']")
       public WebElement userName; //кнопка Войти

        public MainPage clickLoginButton(UserInfo user) {

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

   }


