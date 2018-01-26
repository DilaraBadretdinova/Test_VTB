package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


//TODO Поля пишутся с малеькой буквы, классы с большой
public class CreateNewPP extends Page{
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
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
    public WebElement template_List; // Ссылка Шаблоны
    @FindBy(xpath = "//div[2]/div/label/div")
    public WebElement template_Chekbox; //чекбоксы в списке шаблонов
    @FindBy(xpath = "//button[@class='Button__base--3ZP3W Button__basePrimary--3ryz2']/div")
    public WebElement  template_button; //кнопка выбора шаблонов
    @FindBy(xpath = "//input[@value='Не указан']")
    public WebElement  paymentList; //Поле Вид платежа
    @FindBy(xpath = "//div[@class='field__optionVal1' and text()='Срочно']")
    public WebElement  paymentListSelect; //Элементы списка Вид платежа
    @FindBy(xpath = "//div[@title='Очередность платежа']//div/div/i")
    public WebElement  priorityOfPayment; //Поле очередность платежа
    @FindBy(xpath = "//button[@class='field__labelBtn' and @type='button' and text()='Очередность платежа']")
    public WebElement  linkPriorityOfPayment; //Ссылка очередность платежа
    @FindBy(xpath = "//div[@tabindex][2]/div[2]/div")
    public WebElement  listPriorityOfPayment; //список очередностей
    @FindBy(xpath = "//div[@class='Button__labelClass--_0Dmv' and text()='Применить']")
    public WebElement  buttonPriorityOfPayment; //кнопка выбора очередности
    @FindBy(xpath = "//input[@type='text' and @class='field__input field__input_clearable' and @value and @placeholder='УИН/УИП' and @maxlength='25']")
    public WebElement codeUIP; //поле код
    @FindBy(xpath = "//div[@class='PushItem__text--14a_h' and text()='Внимание! Платеж по системе БЭСП. Повышенная комиссия']")
    public WebElement warning; //поле код

    //номер документа
    public void checkDocNumber(){
        numberDog.click();
        number.click();
        String NumberDog_Str = numberDog.getAttribute("value");
        numberClear.click();
        number.click();
        number.clear();
        number.sendKeys("197");
    }
    //дата
    public void checkDocDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        String dDate =  docDate.getAttribute("value");
        String date_Current = format.format(date.getTime());
      //  Assert.assertEquals(DDate, Date_Current);
        docDate.click();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        dDate = format.format(calendar.getTime());
        docDate.sendKeys(dDate);
    }
    //шаблон
    public void checkTemplate(){
        wait.until(ExpectedConditions.visibilityOf(template));
        template.click();
        wait.until(ExpectedConditions.visibilityOf(list));
        list.click();
        template_List.click();
        wait.until(ExpectedConditions.visibilityOf(template_Chekbox));
        template_Chekbox.click();
        wait.until(ExpectedConditions.visibilityOf(template_button));
        template_button.click();
    }
    //вид платежа
    public void checkTypePayment() {
        
        wait.until(ExpectedConditions.visibilityOf(paymentList));
        paymentList.click();
        paymentListSelect.click();
            }

    //очередность платежа
    public void checkPriorityOfPayment(){
        wait.until(ExpectedConditions.visibilityOf(priorityOfPayment));
         priorityOfPayment.click();
        linkPriorityOfPayment.click();
        wait.until(ExpectedConditions.visibilityOf(listPriorityOfPayment));
        listPriorityOfPayment.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='PushItem__text--14a_h' and text()='Внимание! Платеж по системе БЭСП. Повышенная комиссия']")));
        buttonPriorityOfPayment.click();
           }

    public void checkCodeEnter(){
        codeUIP.click();
        codeUIP.clear();
        codeUIP.sendKeys("39210202010061000160");
    }
}
