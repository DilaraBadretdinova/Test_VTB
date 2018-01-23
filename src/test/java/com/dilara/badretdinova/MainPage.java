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

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private static Logger log = Logger.getLogger(TestVTB.class.getName());

    @FindBy(css = "input.field__input.field__input_clearable")
    WebElement Login;
    @FindBy(css = "div.field.field_input.LoginView__inputPassword--2rpwD > div.field__control > input.field__input.field__input_clearable")
    WebElement Password;
    @FindBy(xpath = "//*[@class='Button__base--3ZP3W Button__baseMinWidth--3NuBa Button__baseMaxWidth--3R5RD LoginView__btnPrimary--3LQGe']")
    WebElement loginButton;
    @FindBy(xpath = "//div[text()='BilalovaLR']")
    WebElement Name;
    @FindBy(xpath = "//div[text()='Создать ПП']")
    WebElement NewPPButton;
    @FindBy(css = "input.field__input.field__input_clearable")
    WebElement Number;
    @FindBy(css = "input.field__input.field__input_clearable")
    WebElement NumberDog;
    @FindBy(css = "div.field__clean")
    WebElement NumberClear;
    @FindBy(css = "input.field__input.undefined ")
    WebElement DocDate;
    @FindBy(css = "i.Icon__icon--66GYG.Icon__arrowDropDown--26iSm")
    WebElement Template;
    @FindBy(css = "div.field__optionVal1")
    WebElement List;
    @FindBy(css = "div.field__inputWrap > input.field__input")
    WebElement List_two;
    @FindBy(css = "button.field__labelBtn")
    WebElement Template_List;
    @FindBy(css = "div.table__cell.table__cell_checkbox > label.field.field_checkbox > div.field__control > div.field__fakeCheckbox")
    WebElement Template_Chekbox;
    @FindBy(css = "div.OverlapButtonPanel__base--17BGu > button.Button__base--3ZP3W.Button__basePrimary--3ryz2")
    WebElement  Template_button;
    @FindBy(css = "div.GridSpan__gridSpan--1jA-G > div.field.field_select > div.field__control > div.field__inputWrap > div.field__icon.field__icon_selectClosed > i.Icon__icon--66GYG.Icon__arrowDropDown--26iSm")
    WebElement  PaymentList;
    @FindBy(css = "//div[@id='appframe']/form/div/div[2]/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/div")
    WebElement  PaymentListSelect;


    public MainPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        FileInputStream fis;
        Properties prop = new Properties();
        try {
            fis = new FileInputStream("src/test/java/com/dilara/badretdinova/config.properties");
            prop.load(fis);
             }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        webDriver.get(prop.getProperty("host"));
        Login.click();
        Login.clear();
        Login.sendKeys(prop.getProperty("login"));
        Password.click();
        Password.clear();
        Password.sendKeys(prop.getProperty("password"));
    }


    public void open() {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Login.click();
        loginButton.click();
        String User = Name.getText();
        Assert.assertEquals("BilalovaLR", User);

    }

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


    }
}
