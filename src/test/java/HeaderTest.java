//import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class HeaderTest extends BaseTest {
        public WebDriver driver;
        BasePage basePage = new BasePage(driver);
        Header header = new Header(driver);


    @BeforeTest
    public void setUp(){
        super.setupTest();
    }

    @Test
    public void checkIfToolsQALogoqoOpenesHomePage() {
        System.out.println("1");
        BasePage basePage = new BasePage(driver);
        Header header = new Header(driver);
        basePage.openUrl();
        header.clickOnElement(header.toolsQaLogoBy);
    }

}


