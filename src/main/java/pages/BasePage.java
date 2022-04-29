package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver ;
    protected WebDriverWait wait;

    private static final int timeout = 3;
    private static final int POLLING = 100;
    private final String url = "https://www.toolsqa.com/";


    public  BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,timeout,POLLING);
        //co to robi?
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }
    public void openUrl() {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void reloadPage() {
        driver.navigate().refresh();
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
