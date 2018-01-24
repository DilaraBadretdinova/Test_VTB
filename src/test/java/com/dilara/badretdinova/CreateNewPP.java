package com.dilara.badretdinova;

import org.junit.Assert;
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
}