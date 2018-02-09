package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CreateNewPP extends Page {

    @FindBy(xpath = "//input[@type='text' and @class='field__input field__input_clearable']")
    public WebElement number; //Поле Номер документа

    @FindBy(xpath = "//input[@type='text' and @class='field__input field__input_clearable']")
    public WebElement numberDog;

    @FindBy(css = "div.field__clean")
    public WebElement numberClear; //Иконка очистить

    @FindBy(xpath = "//input[@type='text' and @class='field__input undefined ']")
    public WebElement docDate; // Поле Дата

    @FindBy(xpath = "//div[@title='Шаблон']//input")
    public WebElement template; //Поле шаблон

    @FindBy(xpath = "//div[@tabindex][3]")
    public WebElement list; //Выпадающий список шаблонов

    @FindBy(xpath = "//button[text()='Шаблон']")
    public WebElement template_Link; // Ссылка Шаблоны

    @FindBy(xpath = "//div[@class='OverlapHeader__title--FWOgP' and text()='Шаблоны платежного поручения']")
    public WebElement template_List;//скроллер список шаблонов

    @FindBy(xpath = "//div[2]/div/label/div")
    public WebElement template_Chekbox; //чекбоксы в списке шаблонов

    @FindBy(xpath = "//button[@class='Button__base--3ZP3W Button__basePrimary--3ryz2']/div")
    public WebElement template_button; //кнопка выбора шаблонов

    @FindBy(xpath = "//input[@value='Не указан']")
    public WebElement paymentList; //Поле Вид платежа

    @FindBy(xpath = "//div[@class='field__optionVal1' and text()='Срочно']")
    public WebElement paymentListSelect; //Элементы списка Вид платежа

    @FindBy(xpath = "//input[@value='Срочно']")
    public WebElement paymentList_quickly;

    @FindBy(xpath = "//input[@value='5' and @type='text']")
    public WebElement paymentList_code;

    @FindBy(xpath = "//div[@title='Очередность платежа']//div/div/i")
    public WebElement priorityOfPayment; //Поле очередность платежа

    @FindBy(xpath = "//button[@class='field__labelBtn' and @type='button' and text()='Очередность платежа']")
    public WebElement linkPriorityOfPayment; //Ссылка очередность платежа

    @FindBy(xpath = "//div[@tabindex][2]/div[2]/div")
    public WebElement listPriorityOfPayment; //список очередностей

    @FindBy(xpath = "//div[@class='Button__labelClass--_0Dmv' and text()='Применить']")
    public WebElement buttonPriorityOfPayment; //кнопка выбора очередности

    @FindBy(xpath = "//input[@type='text' and @class='field__input field__input_clearable' and @value and @placeholder='УИН/УИП' and @maxlength='25']")
    public WebElement codeUIP; //поле код

    @FindBy(xpath = "//div[@class='PushItem__text--14a_h' and text()='Внимание! Платеж по системе БЭСП. Повышенная комиссия']")
    public WebElement warning; //поле код
//////////////////////////////////////////////////////////////
    //  Номер документа

    //номер документа не пусто
    public void nonEmptyValueDocNumber() {
        numberDog.click();
        number.click();
    }

    //ввод номера документа
    public void writeDocNumber() {
        numberClear.click();
        number.click();
        number.clear();
        number.sendKeys("198");
    }

    // ввести только цифры
    public void writeLettersDocNumber() {
        number.click();
        number.clear();
        number.sendKeys("Error");
    }

    //ограничение 15 символов
    public void restrictionDocNumber() {
        number.click();
        number.clear();
        String numberDoc15 = "1111122222333334";
        number.sendKeys(numberDoc15);
    }
///////////////////////////////////////////////////////////

    //Дата
    //текущая дата
    public void writeDocDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        String dDate = docDate.getAttribute("value");
        docDate.click();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        dDate = format.format(calendar.getTime());
        docDate.sendKeys(dDate);
    }

    //ввести только цифры
    public void writeLettersDocDate() {
        docDate.clear();
        docDate.sendKeys("as.df.qwer");
    }
//////////////////////////////////////////////////////////////////

    //Шаблон
    //выбрать из выпадающего списка
    public void selectFromListTemplate() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(template));
        template.click();
        wait.until(ExpectedConditions.visibilityOf(list));
        list.click();
    }

    //открытие скроллера списка шаблонов
    public void openLinkTemplate() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        template_Link.click();
        wait.until(ExpectedConditions.visibilityOf(template_List));

    }

    //выбор из скроллера список шаблонов
    public void selectFromLinkTemplate() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(template_Chekbox));
        template_Chekbox.click();
        wait.until(ExpectedConditions.visibilityOf(template_button));
        template_button.click();
    }
/////////////////////////////////////////////////////////////////

    //Вид платежа
    //выбор вида платежа
    public void selectTypePayment() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(paymentList));
        paymentList.click();
        paymentListSelect.click();
    }
//////////////////////////////////////////////////////////////

    //Очередность платежа
    public void checkPriorityOfPayment() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(priorityOfPayment));
        priorityOfPayment.click();
        linkPriorityOfPayment.click();
        wait.until(ExpectedConditions.visibilityOf(listPriorityOfPayment));
        listPriorityOfPayment.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='PushItem__text--14a_h' and text()='Внимание! Платеж по системе БЭСП. Повышенная комиссия']")));
        buttonPriorityOfPayment.click();
    }

    /////////////////////////////////////////////////////////////
    //Код
    public void checkCodeEnter() {
        codeUIP.click();
        codeUIP.clear();
        codeUIP.sendKeys("39210202010061000160");
    }
    public static byte[] takeScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
