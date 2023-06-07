package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.component.LogoComponent;

public class TrackOrderPage {
    private final WebDriver driver;
    private final By containerOrderNotFound = By.className("Track_NotFound__6oaoY"); // Такого заказа нет
    private final LogoComponent logo;
    public TrackOrderPage(WebDriver driver) {
        this.driver = driver;
        this.logo = new LogoComponent(driver);
    }

    public boolean isContainerOrderNotFoundVisible() {
        return driver.findElement(containerOrderNotFound).isDisplayed(); // отображается ли баннер Такого заказа нет
    }
}
