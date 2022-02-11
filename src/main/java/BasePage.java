import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class BasePage {
    protected static WebDriver driver;
    protected WebDriverWait wait;

    private static final int timeout = 10;
    private static final int POLLING = 100;

    public static final String url = "https://www.toolsqa.com/";

    public  BasePage(WebDriver driver) {
        this.driver = new ChromeDriver();
        wait = new WebDriverWait(driver,timeout, POLLING);
        //co to robi?
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public static void openUrl() {
        driver.get(url);
        driver.manage().window().fullscreen();
    }
    public void reloadPage() {
        driver.navigate().refresh();
    }

    public static WebElement setElement(By byLocator) {
        return driver.findElement(byLocator);
    }

    public static WebElement clickOnElement(By byLocator) {
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
