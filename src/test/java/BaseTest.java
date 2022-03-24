import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public  class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public void setupClass() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    //@AfterSuite
    public void teardown() {
        driver.quit();
    }
}
