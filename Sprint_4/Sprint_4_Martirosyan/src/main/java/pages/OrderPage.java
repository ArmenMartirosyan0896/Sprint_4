package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;

    // Окно для кого самокат
    private final By orderTitle = By.className("Order_Header__BZXOb");//заголовок
    private By windowOrderForWho = By.xpath("/html/body/div/div/div[2]");
    private By fldUserFirstName = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input"); // поле Имя
    private By fldUserSecondName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input"); // поле Фамилия
    private By fldAdress = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input"); // поле Адрес
    private By fldStantion = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");// поле Станция
    private final By listOfSubwayStations = By.xpath(".//div[@class = 'select-search__select']"); // выпадающий список станций
    private final By subwayStation = By.xpath(".//div[@class = 'select-search__select']//li"); // конкретная станция метро
    private By fldPhoneNumber = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input"); // поле Номер телефона
    private By btnNext = By.xpath("/html/body/div/div/div[2]/div[3]/button"); // Кнопка Далее

    // Окно про аренду
    private By fldDate = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input"); // Когда привезти самокат
    private By amountOfDays = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div/div[1]"); // Срок аренды
    private By listOfAmountOfDays = By.xpath(".//div[@class = 'Dropdown-menu']//div"); //Выпадающий список срока аренды
    private By scooterColor = By.xpath(".//div[@class = 'Order_Checkboxes__3lWSI']//input"); // Цвет самоката
    private By deliveryMessage = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input"); // Комментарий для курьера
    private By backButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[1]"); // Кнопка назад
    private By lastOrderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]"); // Кнопка Заказать

    // Окно Хотите оформить заказ
    private By noButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[1]"); // Кнопка Нет
    private By yesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]"); // Кнопка Да
    private By orderMessage = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]"); // Сообщение о том, что заказ сформирован
    private final By btnCheckOrderStatus = By.xpath(".//button[text(] = 'Посмотреть статус'");

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
    public OrderPage coockiesBtn() {
        driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/button")).click();
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
    public OrderPage clickCheckOrderStatus(){
        driver.findElement(btnCheckOrderStatus).click();
        return this;
    }
}
