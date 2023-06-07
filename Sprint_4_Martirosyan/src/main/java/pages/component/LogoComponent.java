package pages.component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LogoComponent {
    private final WebDriver driver;
    public static final By containerLogo = By.className("Header_Logo__23yGT");
    public LogoComponent(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLogo() {
        driver.findElement(containerLogo).click();
    }
}
