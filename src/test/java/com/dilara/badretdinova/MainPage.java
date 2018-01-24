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
    @FindBy(css = "input.field__input.undefined ")
    public WebElement DocDate; // Поле Дата
    @FindBy(css = "i.Icon__icon--66GYG.Icon__arrowDropDown--26iSm")
    public WebElement Template; //Поле шаблон
    @FindBy(css = "div.field__optionVal1")
    public WebElement List; //Выпадающий список шаблонов
    @FindBy(css = "div.field__inputWrap > input.field__input")
    public WebElement List_two; //Элементы выпадающего списка
    @FindBy(css = "button.field__labelBtn")
    public WebElement Template_List; // Ссылка Шаблоны
    @FindBy(css = "div.table__cell.table__cell_checkbox > label.field.field_checkbox > div.field__control > div.field__fakeCheckbox")
    public WebElement Template_Chekbox; //чекбоксы в списке шаблонов
    @FindBy(css = "div.OverlapButtonPanel__base--17BGu > button.Button__base--3ZP3W.Button__basePrimary--3ryz2")
    public WebElement  Template_button; //кнопка выбора шаблонов
    @FindBy(css = "div.GridSpan__gridSpan--1jA-G > div.field.field_select > div.field__control > div.field__inputWrap > div.field__icon.field__icon_selectClosed > i.Icon__icon--66GYG.Icon__arrowDropDown--26iSm")
    public WebElement  PaymentList; //Поле Вид платежа
    @FindBy(css = "//div[@id='appframe']/form/div/div[2]/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/div")
    public WebElement  PaymentListSelect; //Элементы списка Вид платежа

}
