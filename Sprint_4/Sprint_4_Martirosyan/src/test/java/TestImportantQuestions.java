import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestImportantQuestions {
    public final int questIndex;
    public final int ansIndex;
    public final String expectedAnsText;
    private WebDriver driver;


    public TestImportantQuestions(int questIndex, String expectedAnsText, int ansIndex) {
        this.questIndex = questIndex;
        this.ansIndex = ansIndex;
        this.expectedAnsText = expectedAnsText;
    }
    @Parameterized.Parameters
    public static Object[][] getTexts() {
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }
    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }
    @Test
    public void testGetText() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickQuestion(questIndex);
        objMainPage.getAnswerTexts(ansIndex);
        assertEquals(expectedAnsText, objMainPage.getAnswerTexts(ansIndex));
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
