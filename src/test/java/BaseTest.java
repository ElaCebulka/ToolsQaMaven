import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public  class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public void setupClass() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @BeforeTest
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void closeWindow() {
       // driver.close();
    }

    @AfterSuite
    public void teardown() {
       // driver.quit();
    }
}
