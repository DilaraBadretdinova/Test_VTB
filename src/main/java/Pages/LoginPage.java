package Pages;

import User.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {

        @FindBy(xpath = "//input[@type='text']")
        private WebElement Login; //поле логин
        @FindBy(xpath = "//input[@type='password']")
        private WebElement Password; //поле пароль
        @FindBy(xpath = "//button[text()='Войти']")
        private WebElement LoginButton; //кнопка Войти
       @FindBy(xpath = "//div[text()='BilalovaLR']")
       public WebElement UserName; //кнопка Войти

        public MainPage clickLoginButton(UserInfo user) {

            Login.click();
            Login.clear();
            Login.sendKeys(user.getLogin());

            Password.click();
            Password.clear();
            Password.sendKeys(user.getPassword());

            LoginButton.click();
              return new MainPage();

        }

   }


