package com.dilara.badretdinova;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.sun.activation.registries.LogSupport.log;

public class CreateNewPP {
    private WebDriver driver;
    public CreateNewPP(WebDriver driver){this.driver = driver; }

    public void docNumber(){
        MainPage mainPage= new MainPage();
        PageFactory.initElements(driver, mainPage);
        mainPage.NumberDog.click();
        mainPage.Number.click();
        String NumberDog_Str = mainPage.NumberDog.getAttribute("value");
        mainPage.NumberClear.click();
        mainPage.Number.click();
        mainPage.Number.clear();
        mainPage.Number.sendKeys("197");
    }

    public void docDate(){
        MainPage mainPage= new MainPage();
        PageFactory.initElements(driver, mainPage);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        String DDate =  mainPage.DocDate.getAttribute("value");
        String Date_Current = format.format(date.getTime());
        Assert.assertEquals(DDate, Date_Current);
        mainPage.DocDate.click();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        DDate = format.format(calendar.getTime());
        mainPage.DocDate.sendKeys(DDate);
    }
    //шаблон
    public void template(){
        MainPage mainPage= new MainPage();
        PageFactory.initElements(driver, mainPage);

        mainPage.Template.click();
        mainPage.List.click();
        mainPage.List_two.click();
        mainPage.Template_List.click();
        mainPage.Template_Chekbox.click();
        mainPage.Template_button.click();
    }
    //вид платежа
    public void payment() {
        MainPage mainPage= new MainPage();
        PageFactory.initElements(driver, mainPage);
        mainPage.PaymentList.click();
        driver.findElement(By.cssSelector("div.PayDocRu__paymentUrgent--HYBr1 > div.field.field_select > div.field__label > button.field__labelBtn")).click();
        driver.findElement(By.xpath("//div[@id='appframe']/form/div/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div")).click();
        driver.findElement(By.xpath("//div[@id='appframe']/form/div/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div")).click();
        //        PaymentListSelect.click();
        //String PaymentList_Str = PaymentList.getAttribute("value");
        }
}
