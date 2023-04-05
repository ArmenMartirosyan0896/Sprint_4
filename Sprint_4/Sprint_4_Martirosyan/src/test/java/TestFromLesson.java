import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static junit.framework.TestCase.assertTrue;

public class TestFromLesson {
    private WebDriver driver;
    private final String incorrectOrderNum = "5";
    @Before

    public void setup() {

        driver = WebDriverFactory.get();

    }
    // Browser factory
    @Test

    public void checkErrorInCaseOfNonexistentOrder() {
        boolean isOrderNotFoundVisible = new MainPage(driver)
                .clickOrderStatusButton()
                .setOrderNumber(incorrectOrderNum)
                .clickSearchButton()
                .isContainerOrderNotFoundVisible();
        assertTrue(isOrderNotFoundVisible);
        }
    @After
    public void teardown() {

        driver.quit();

        }
    }

