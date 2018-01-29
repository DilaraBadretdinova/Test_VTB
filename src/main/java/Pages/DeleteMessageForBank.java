package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public WebElement yesDeleteButton;//удалить сообщение


    private final Wait<WebDriver> wait = new WebDriverWait(driver, 7, 1000);


    public void cancleDeleteMessageForBank() {
        messageForBank.click();
        buttonMessageForBank.click();
        buttonInsertMessageForBank.click();
        inputMessageForBank.sendKeys("My Test");
        buttonSaveMessageForBank.click();
        wait.until(ExpectedConditions.visibilityOf(listMessageForBank));
        listMessageForBank.click();
        deleteListMessageForBank.click();
        closeConfirmation.click();
        deleteListMessageForBank.click();
        yesDeleteButton.click();
    }

}
