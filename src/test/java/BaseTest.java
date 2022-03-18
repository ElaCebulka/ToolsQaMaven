import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public  class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public WebDriver setupClass() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        return driver;
      /*
       WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();*/
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
