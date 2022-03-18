import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public  class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public void setupClass() {
       WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
