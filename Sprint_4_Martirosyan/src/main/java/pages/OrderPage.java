package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class OrderPage {
    private final WebDriver driver;

    // Окно для кого самокат
    private By windowOrderForWho = By.className("Order_Content__bmtHS");
    private final By orderTitle = By.className("Order_Header__BZXOb");//заголовок
    private By fldUserFirstName = By.xpath(".//input[@placeholder = '* Имя']"); // поле Имя
    private By fldUserSecondName = By.xpath(".//input[@placeholder = '* Фамилия']"); // поле Фамилия
    private By fldAdress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']"); // поле Адрес
    private By fldStantion = By.className("select-search__input");// поле Станция
    private final By listOfSubwayStations = By.xpath(".//div[@class = 'select-search__select']"); // выпадающий список станций
    private final By subwayStation = By.xpath(".//div[@class = 'select-search__select']//li"); // конкретная станция метро
    private By fldPhoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']"); // поле Номер телефона
    private By btnNext = By.xpath(".//button[text() = 'Далее']"); // Кнопка Далее
    private By coockiesBtn = By.xpath(".//button[text() = 'да все привыкли']"); // Кнопка "Да все привыкли"

    // Окно про аренду
    private By fldDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']"); // Когда привезти самокат
    private By amountOfDays = By.xpath(".//div[@class ='Dropdown-control']"); // Срок аренды
    private By listOfAmountOfDays = By.xpath(".//div[@class = 'Dropdown-menu']//div"); //Выпадающий список срока аренды
    private By scooterColor = By.xpath(".//div[@class = 'Order_Checkboxes__3lWSI']//input"); // Цвет самоката
    private By deliveryMessage = By.xpath(".//input[@placeholder = 'Комментарий для курьера']"); // Комментарий для курьера
    private By backButton = By.xpath(".//div[@class='Order_Content__bmtHS']//button[text() = 'Назад']"); // Кнопка назад
    private By lastOrderButton = By.xpath(".//div[@class='Order_Content__bmtHS']//button[text() = 'Заказать']"); // Кнопка Заказать

    // Окно Хотите оформить заказ
    private By noButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']//button[text() = 'Нет']"); // Кнопка Нет
    private By yesButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']//button[text() = 'Да']"); // Кнопка Да
    private By orderMessage = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']//div[text() = 'Заказ оформлен']"); // Сообщение о том, что заказ сформирован
    private final By btnCheckOrderStatus = By.xpath(".//button[text() = 'Посмотреть статус']");

    // Заполнение заказа
    public OrderPage (WebDriver driver) {

        this.driver = driver;
    }
    public OrderPage inputFldUserFirstName(String firstName) {
        driver.findElement(fldUserFirstName).sendKeys(firstName);
        return this;
    }
    public OrderPage inputFldUserSecondName(String secondName) {
        driver.findElement(fldUserSecondName).sendKeys(secondName);
        return this;
    }
    public OrderPage inputFldAdress(String adress) {
        driver.findElement(fldAdress).sendKeys(adress);
        return this;
    }
    public OrderPage inputFldStantion(int index) {
        driver.findElement(fldStantion).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(listOfSubwayStations));
        driver.findElements(subwayStation).get(index).click();
        return this;
    }
    public OrderPage inputFldPhoneNumber(String phoneNumber) {
        driver.findElement(fldPhoneNumber).sendKeys(phoneNumber);
        return this;
    }
    public OrderPage clickBtnNext() {
        driver.findElement(btnNext).click();
        return this;
    }
    public OrderPage coockiesBtnClick() {
        driver.findElement(coockiesBtn).click();
        return this;
    }
    public OrderPage inputFldDate(String orderWhen) {
        driver.findElement(fldDate).sendKeys(orderWhen);
        driver.findElement(orderTitle).click();  // необходимо нажать на какой-то элемент (в данном случае на заголовок), чтобы можно было нажать на следующее поле
        return this;
    }
    public OrderPage inputAmountOfDays(int index) {
        driver.findElement(amountOfDays).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(listOfAmountOfDays));
        driver.findElements(listOfAmountOfDays).get(index).click();
        return this;
    }
    public OrderPage inputScooterColor(int index) {
        driver.findElements(scooterColor).get(index).click();
        return this;
    }
    public OrderPage inputDeliveryMessage(String message) {
        driver.findElement(deliveryMessage).sendKeys(message);
        return this;
    }
    public OrderPage clickLastOrderBtn() {
        driver.findElement(lastOrderButton).click();
        return this;
    }
    public OrderPage clickYesBtn(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        driver.findElement(yesButton).click();
        return this;
    }
    public OrderPage waitOrderMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderMessage));
        return this;
    }
    public OrderPage clickCheckOrderStatus() {
        driver.findElement(btnCheckOrderStatus).click();
        return this;
    }
    public  OrderPage checkOrderMessage() {
        Assert.assertTrue(driver.findElement(orderMessage).getText().contains("Заказ оформлен"));
        return this;
    }
}
