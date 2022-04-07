package tests;

import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public  class BaseTest {

    public WebDriver driver;

    @BeforeSuite

    public void setupClass() {
        driver = DriverFactory.getDriver(DriverType.CHROME);
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
