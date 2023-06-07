import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.OrderPage;

@RunWith(Parameterized.class)
public class TestPositiveOrder {
    private WebDriver driver;
    private final int btnOrderIndex;
    private final String firstName;
    private final String secondName;
    private final String adress;
    private final int subwayStationIndex;
    private final String phoneNumber;
    private final String orderDate;
    private final int amountOfDaysIndex;
    private final int scooterColorIndex;
    private final String message;

    public TestPositiveOrder(int btnOrderIndex,
                      String firstName,
                      String secondName,
                      String adress,
                      int subwayStationIndex,
                      String phoneNumber,
                      String orderDate,
                      int amountOfDaysIndex,
                      int scooterColorIndex,
                      String message) {
        this.btnOrderIndex = btnOrderIndex;
        this.firstName = firstName;
        this.secondName = secondName;
        this.adress = adress;
        this.subwayStationIndex = subwayStationIndex;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.amountOfDaysIndex = amountOfDaysIndex;
        this.scooterColorIndex = scooterColorIndex;
        this.message = message;
    }
    @Parameterized.Parameters
    public static Object[][] TestPositiveOrderData() {
        return new Object[][]{
                {0, "Армен", "Мовсесов", "Пушкина Колотушкина 2", 1, "79666666666", "03.05.2023", 3, 0, ""},
                {1, "Валерий", "Апланов", "Москва, Пушкина, 12", 2, "79888844556", "13.04.2023", 1, 0, ""},
                {0, "Кирилл", "Семенко", "Санкт-Петербург, Ленинградская улица, 8", 1, "79999999999", "03.03.2023", 2, 1, ""}
        };
    }
    @Before
    public void setup() {

        driver = WebDriverFactory.get();

    }
    @Test
    public void orderingTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnOrderGeneral(btnOrderIndex);
        OrderPage orderPage = new OrderPage(driver);
                orderPage.inputFldUserFirstName(firstName);
                orderPage.inputFldUserSecondName(secondName);
                orderPage.inputFldAdress(adress);
                orderPage.inputFldStantion(subwayStationIndex);
                orderPage.inputFldPhoneNumber(phoneNumber);
                orderPage.coockiesBtn();
                orderPage.clickBtnNext();
                orderPage.inputFldDate(orderDate);
                orderPage.inputAmountOfDays(amountOfDaysIndex);
                orderPage.inputScooterColor(scooterColorIndex);
                orderPage.inputDeliveryMessage(message);
                orderPage.clickLastOrderBtn();
                orderPage.clickYesBtn();
                orderPage.clickCheckOrderStatus();
    }
    @After
    public void teardown() {
        driver.quit();
    }











}
