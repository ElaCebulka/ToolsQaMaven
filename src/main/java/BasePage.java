import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    private static final int timeout = 10;
    private static final int POLLING = 100;

    public static final String url = "https://www.toolsqa.com/";

    public BasePage(WebDriver driver) {
        this.driver = new ChromeDriver();
        //wait = new WebDriverWait(driver,timeout, POLLING);
        //co to robi?
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public void openUrl() {
        driver.get(url);
    }
    public void reloadPage() {
        driver.navigate().refresh();
    }

    public WebElement setElement(By byLocator) {
        return driver.findElement(byLocator);
    }

    public WebElement clickOnElement(By byLocator) {
        setElement(byLocator);
        WebElement elementToClick = driver.findElement(byLocator);
        elementToClick.click();
        return elementToClick;
    }

    public void scrollToSeeElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    boolean isLoaded() {
        return false;
    }
}
