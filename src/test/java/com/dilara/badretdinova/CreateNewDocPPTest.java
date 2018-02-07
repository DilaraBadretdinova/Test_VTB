package com.dilara.badretdinova;

import Pages.ConfigProperties;
import Pages.CreateNewPP;
import Pages.LoginPage;
import Pages.MainPage;
import User.UserInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Pages.Page;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
@Title("Создание нового ПП")
public class CreateNewDocPPTest {
    public WebDriver driver;
    private static Logger log = Logger.getLogger(CreateNewDocPPTest.class.getName());

    @Before
    public void setUp() {
        new Page().getDriver().get(ConfigProperties.getTestProperty("host"));
        UserInfo user = new UserInfo("1111111111", "1111111111");
        new LoginPage().clickLoginButton(user);
        new MainPage().clickCreateNewPP();

    }

    ////////////////Номер документа///////////////////////
    @Title("Проверка поля Номер документа")
    @Test
    public void verificationDocNumber() {
        CreateNewPP createNewPP = new CreateNewPP();
        //поле не пусто
        createNewPP.nonEmptyValueDocNumber();
        Assert.assertTrue("Поле пустое", createNewPP.number.getAttribute("value") != null);
        //в поле можно ввести цифры
        createNewPP.writeDocNumber();
        Assert.assertEquals("Не соответствует введенному значению", "198", createNewPP.number.getAttribute("value"));
        //в поле можно нельзя ввести буквы
        createNewPP.writeLettersDocNumber();
        Assert.assertTrue("Записаны буквы", createNewPP.number.getAttribute("value") != null);
        //ограничение в 15 символов
        createNewPP.restrictionDocNumber();
        Assert.assertTrue("Требование ограничения длины не выполнено", createNewPP.number.getAttribute("value") != "1111122222333334");
        log.info("Passed");
    }

    ///////////////Дата документа////////////////////
    @Title("Проверка поля Дата документа")
    @Test
    public void verificationDocDate() {
        CreateNewPP createNewPP = new CreateNewPP();
        //проверка текущей даты
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Assert.assertEquals("Текущая дата не верна", createNewPP.docDate.getAttribute("value"), format.format(date.getTime()));
        //проверка возможности ввести вручную
        createNewPP.writeDocDate();
        //можно ввести только цифры
        createNewPP.writeLettersDocDate();
        Assert.assertTrue("Записаны буквы", createNewPP.docDate.getAttribute("value") != null);
    }

    /////////////////Шаблон///////////////////
    @Title("Проверка списка Шаблоны")
    @Test
    public void verificationTemplate() {
        CreateNewPP createNewPP = new CreateNewPP();
        //выбрать из выпадающего списка
        createNewPP.selectFromListTemplate();
        Assert.assertTrue("Шаблон не выбран", createNewPP.template.getAttribute("value") != "123");
        //открытие скроллера Шаблоны
        createNewPP.openLinkTemplate();
        Assert.assertEquals("Скроллер не открыт", createNewPP.template_List.getText(), "Шаблоны платежного поручения");
        //выбор шаблона
        createNewPP.selectFromLinkTemplate();
        Assert.assertTrue("Шаблон не выбран", createNewPP.template.getAttribute("value") != "dsdsd");

    }

    ///////////////////////////////////////вид платежа
    @Title("Проверка списка Вид платежа")
    @Test
    public void verificationTypePayment() {
        CreateNewPP createNewPP = new CreateNewPP();
        createNewPP.selectTypePayment();
        Assert.assertTrue("Вид платежа не выбран", createNewPP.paymentList_quickly.getAttribute("value") != null);
    }

    ///////////////////////////////////очередность платежа
    @Title("Проверка Очередность платежа")
    @Test
    public void verificationPriorityTypeOfPayment() {
        new Pages.CreateNewPP().checkPriorityOfPayment();
    }

    ////////////////////////////////////код
    @Title("Проверка поля Код")
    @Test
    public void verificationCodeEnter() {
        new Pages.CreateNewPP().checkCodeEnter();
    }

    @After
    public void updatePage() {
        driver = null;
    }
}
