package extensions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.component.LogoComponent;
import java.time.Duration;
import static config.AppConfig.URL;
import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;

public class WebDriverFactory {
    public static WebDriver get() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "/Users/armenmartirosan/Downloads/chromedriver_mac_arm64/chromedriver");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver;
        String browserName = System.getenv().get("browser");
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser " + browserName + " not exist");
        }
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_SECONDS_TIMEOUT));
        return driver;
    }
}