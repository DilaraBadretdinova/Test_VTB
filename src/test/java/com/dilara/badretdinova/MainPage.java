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
    @FindBy(css = "input.field__input.field__input_clearable")
   public WebElement Login; //поле логин
    @FindBy(css = "div.field.field_input.LoginView__inputPassword--2rpwD > div.field__control > input.field__input.field__input_clearable")
    public WebElement Password; //поле пароль
    @FindBy(xpath = "//*[@class='Button__base--3ZP3W Button__baseMinWidth--3NuBa Button__baseMaxWidth--3R5RD LoginView__btnPrimary--3LQGe']")
    public WebElement loginButton; //кнопка Войти
    @FindBy(xpath = "//div[text()='BilalovaLR']")
    public WebElement Name; //Лейбл user
    @FindBy(xpath = "//div[text()='Создать ПП']")
    public WebElement NewPPButton; //кнопка Создать ПП
    @FindBy(css = "input.field__input.field__input_clearable")
    public WebElement Number; //Поле Номер документа
    @FindBy(css = "input.field__input.field__input_clearable")
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



/*

    //новый ПП и номер документа
    public void newPP() {
        NewPPButton.click();
        Number.click();
        String NumberDog_Str = NumberDog.getAttribute("value");
        if (NumberDog_Str != " ") log.fine("Passed");
        NumberClear.click();
        Number.click();
        Number.clear();
        Number.sendKeys("197");

    }
//проверка даты
    public void dateDoc() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        String DDate =  DocDate.getAttribute("value");
        String Date_Current = format.format(date.getTime());
        Assert.assertEquals(DDate, Date_Current);
        DocDate.click();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        DDate = format.format(calendar.getTime());
        DocDate.sendKeys(DDate);

    }
    //шаблон
    public void template(){
        Template.click();
        List.click();
        List_two.click();
        Template_List.click();
        Template_Chekbox.click();
        Template_button.click();
    }
    //вид платежа
    public void payment() {
        PaymentList.click();
        webDriver.findElement(By.cssSelector("div.PayDocRu__paymentUrgent--HYBr1 > div.field.field_select > div.field__label > button.field__labelBtn")).click();
        webDriver.findElement(By.xpath("//div[@id='appframe']/form/div/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div")).click();
        webDriver.findElement(By.xpath("//div[@id='appframe']/form/div/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div")).click();
        //        PaymentListSelect.click();
        String PaymentList_Str = PaymentList.getAttribute("value");


    }*/
}
