package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class CreateNewPP extends Page{
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

    //номер документа
    public void checkDocNumber(){
        NumberDog.click();
        Number.click();
        String NumberDog_Str = NumberDog.getAttribute("value");
        NumberClear.click();
        Number.click();
        Number.clear();
        Number.sendKeys("197");
    }
    //дата
    public void checkDocDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        String DDate =  DocDate.getAttribute("value");
        String Date_Current = format.format(date.getTime());
      //  Assert.assertEquals(DDate, Date_Current);
        DocDate.click();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        DDate = format.format(calendar.getTime());
        DocDate.sendKeys(DDate);
    }
    //шаблон
    public void checkTemplate(){
        Template.click();
        List.click();
        Template_List.click();
        Template_Chekbox.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Template_button.click();
    }
    //вид платежа
    public void checkTypePayment() {
        PaymentList.click();
        PaymentListSelect.click();
            }
    //очередность платежа
    public void checkPriorityOfPayment(){

       PriorityOfPayment.click();
        LinkPriorityOfPayment.click();
        ListPriorityOfPayment.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='PushItem__text--14a_h' and text()='Внимание! Платеж по системе БЭСП. Повышенная комиссия']")));
        ButtonPriorityOfPayment.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void checkCodeEnter(){
        CodeUIP.click();
        CodeUIP.clear();
        CodeUIP.sendKeys("39210202010061000160");
    }
}
