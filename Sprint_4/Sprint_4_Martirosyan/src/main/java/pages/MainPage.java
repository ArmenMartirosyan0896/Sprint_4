package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.component.LogoComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.OrderPage;

public class MainPage {
    private final WebDriver driver;
    private final LogoComponent logo; // логотип Яндекс.Самокат
    private final By btnOrderGeneral = By.xpath(".//button[text()='Заказать']"); // общий локатор для кнопок перехода к заказу
    private final By btnOrderStatus = By.className("Header_Link__1TAG7"); // Кнопка Статус заказа
    private final By inputOrderNum = By.xpath("//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']"); // Поле Введите номер заказа (появляется после нажатия на статус заказа)
    private final By btnSearch = By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']"); // Кнопка Go

// Список вопросов
    private final By listOfQuestions = By.xpath(".//div[@class='accordion__item']");
    private final By answer = By.xpath(".//div[@class='accordion__item']//p");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        logo = new LogoComponent(driver);
    }

    public OrderPage clickBtnOrderGeneral(int index) { //Общий метод для двух кнопок перехода к заказу
        WebElement element = driver.findElements(btnOrderGeneral).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElements(btnOrderGeneral).get(index).click();
        return new OrderPage(driver);
    }
    public MainPage clickOrderStatusButton() {
        driver.findElement(btnOrderStatus).click(); // кликнуть на Статус заказа
        return this;
    }

    public MainPage setOrderNumber(String orderNum) {
        driver.findElement(inputOrderNum).sendKeys(orderNum); // ввести в поле Введите номер заказа номер
        return this;
    }

    public TrackOrderPage clickSearchButton() {
        driver.findElement(btnSearch).click(); // Нажать на кнопку Go
        return new TrackOrderPage(driver);
    }

    //клик по вопросу
    public MainPage clickQuestion(int index) {
        WebElement element = driver.findElements(listOfQuestions).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments [0].scrollIntoView();", element);
        driver.findElements(listOfQuestions).get(index).click();
        return this;
    }
            //получение текста ответа
        public String getAnswerTexts (int index) {
            WebElement element = driver.findElements(listOfQuestions).get(index);
            ((JavascriptExecutor) driver).executeScript("arguments [0].scrollIntoView();", element);
            return driver.findElements(answer).get(index).getText();
        }
    }

