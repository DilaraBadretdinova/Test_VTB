package com.dilara.badretdinova;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import static com.sun.activation.registries.LogSupport.log;

public class CreateNewPP {
    private WebDriver driver;
    public CreateNewPP(WebDriver driver){this.driver = driver; }

    //номер документа
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
//дата документа
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
        mainPage.Template_List.click();
        mainPage.Template_Chekbox.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.Template_button.click();
    }
    //вид платежа
    public void typePayment() {
        MainPage mainPage = new MainPage();
        PageFactory.initElements(driver, mainPage);
        mainPage.PaymentList.click();
        mainPage.PaymentListSelect.click();

    }
    public void priorityOfPayment(){
        MainPage mainPage = new MainPage();
        PageFactory.initElements(driver, mainPage);
        mainPage.PriorityOfPayment.click();
        mainPage.LinkPriorityOfPayment.click();
        mainPage.ListPriorityOfPayment.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='PushItem__text--14a_h' and text()='Внимание! Платеж по системе БЭСП. Повышенная комиссия']")));
        mainPage.ButtonPriorityOfPayment.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                }

    public void codeEnter(){
        MainPage mainPage = new MainPage();
        PageFactory.initElements(driver, mainPage);
        mainPage.CodeUIP.click();
        mainPage.CodeUIP.clear();
        mainPage.CodeUIP.sendKeys("39210202010061000160");

    }
}
