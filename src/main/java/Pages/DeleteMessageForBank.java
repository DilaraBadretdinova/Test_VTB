package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

import java.util.NoSuchElementException;

import static Pages.Page.driver;

public class DeleteMessageForBank extends Page {
    @FindBy(xpath = "//div[text()='Сообщение для банка']")
    public WebElement messageForBank; //панель Сообщение для банка

    @FindBy(xpath = "//button[text()='Сообщение для Банка']")
    public WebElement buttonMessageForBank; //кнопка Сообщение для банка

    @FindBy(xpath = "//span[text()='Добавить']")
    public WebElement buttonInsertMessageForBank;//добавить сообщение

    @FindBy(xpath = "//div[@class='field field_textarea']/div[2]/textarea")
    public WebElement inputMessageForBank;//поле сообщение

    @FindBy(xpath = "//button[@class='Button__base--3ZP3W Button__basePrimary--3ryz2 OverlapButtonPanel__wrapRightButton--3Eqbi']/div")
    public WebElement buttonSaveMessageForBank;//кнопка сохранить сообщение

    @FindBy(xpath = "//span[text()='My Test']")
    public WebElement listMessageForBank;//список сообщений

    @FindBy(xpath = " //span[text()='Удалить']")
    public WebElement deleteListMessageForBank;//удалить сообщение

    @FindBy(xpath = "//button[@class='CloseBtn__base--2fVJi CloseBtn__positionAbsolut--1fhGp']/i")
    public WebElement closeConfirmation;//удалить сообщение

    @FindBy(xpath = "//div[text()='Да']")
    public WebElement yesDeleteButton;//подтвердить удаление сообщения


    public void deleteMessageForBank() {
         messageForBank.click();
        buttonMessageForBank.click();
        buttonInsertMessageForBank.click();
        inputMessageForBank.sendKeys("My Test");
        buttonSaveMessageForBank.click();
        new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(listMessageForBank));
        listMessageForBank.click();
        deleteListMessageForBank.click();
        closeConfirmation.click();
        deleteListMessageForBank.click();
        yesDeleteButton.click();
    }
    public static byte[] takeScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}
