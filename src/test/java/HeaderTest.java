//import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.*;

public class HeaderTest extends BaseTest {

    @BeforeTest
    public void setUp(){
        super.setupTest();
    }

    @Test
    public void checkIfToolsQALogoqoOpenesHomePage() {
        System.out.println("1");
        Header header = new Header(driver);
        BasePage.openUrl();
        header.clickOnElement(header.toolsQaLogoBy);
    }

}


