import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void setupTest() {
        driver = new ChromeDriver();
    }

    public void teardown() {
        driver.quit();
    }
}
