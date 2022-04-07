package tests;

import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
//import org.junit.Befo;
import org.testng.annotations.BeforeSuite;

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
