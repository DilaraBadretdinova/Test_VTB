package com.dilara.badretdinova;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

class MainPage {
    @FindBy(xpath = "//input[@type='text']")
   public WebElement Login; //поле логин
    @FindBy(xpath = "//input[@type='password']")
    public WebElement Password; //поле пароль
    @FindBy(xpath = "//*[@class='Button__base--3ZP3W Button__baseMinWidth--3NuBa Button__baseMaxWidth--3R5RD LoginView__btnPrimary--3LQGe']")
    public WebElement loginButton; //кнопка Войти
    @FindBy(xpath = "//div[text()='BilalovaLR']")
    public WebElement Name; //Лейбл user
    @FindBy(xpath = "//div[text()='Создать ПП']")
    public WebElement NewPPButton; //кнопка Создать ПП
    @FindBy(xpath = "//input[@type='text' and @class='field__input field__input_clearable']")
    public WebElement Number; //Поле Номер документа
    @FindBy(xpath = "//input[@type='text' and @class='field__input field__input_clearable']")
    public WebElement NumberDog;
    @FindBy(css = "div.field__clean")
    public WebElement NumberClear; //Иконка очистить
    @FindBy(xpath = "//input[@type='text' and @class='field__input undefined ']")
    public WebElement DocDate; // Поле Дата
    @FindBy(xpath = "//div[@title='Шаблон']//input")
    public WebElement Template; //Поле шаблон
    @FindBy(xpath = "//div[@tabindex][3]")
    public WebElement List; //Выпадающий список шаблонов
    //@FindBy(css = "div.field__inputWrap > input.field__input")
   // public WebElement List_two; //Элементы выпадающего списка
    @FindBy(xpath = "//button[text()='Шаблон']")
    public WebElement Template_List; // Ссылка Шаблоны
    @FindBy(xpath = "//div[2]/div/label/div")
    public WebElement Template_Chekbox; //чекбоксы в списке шаблонов
    @FindBy(xpath = "//button[@class='Button__base--3ZP3W Button__basePrimary--3ryz2']/div")
    public WebElement  Template_button; //кнопка выбора шаблонов
    @FindBy(xpath = "//input[@value='Не указан']")
    public WebElement  PaymentList; //Поле Вид платежа
    @FindBy(xpath = "//div[@class='field__optionVal1' and text()='Срочно']")
    public WebElement  PaymentListSelect; //Элементы списка Вид платежа
    @FindBy(xpath = "//input[@value='5']")
    public WebElement  PriorityOfPayment; //Поле очередность платежа
    @FindBy(xpath = "//button[@class='field__labelBtn' and @type='button' and text()='Очередность платежа']")
    public WebElement  LinkPriorityOfPayment; //Ссылка очередность платежа
    @FindBy(xpath = "//div[@tabindex][2]/div[2]/div")
    public WebElement  ListPriorityOfPayment; //список очередностей
    @FindBy(xpath = "//div[@class='Button__labelClass--_0Dmv' and text()='Применить']")
    public WebElement  ButtonPriorityOfPayment; //кнопка выбора очередности
    @FindBy(xpath = "//input[@type='text' and @class='field__input field__input_clearable' and @value and @placeholder='УИН/УИП' and @maxlength='25']")
    public WebElement CodeUIP; //поле код
}
