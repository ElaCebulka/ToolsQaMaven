package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.*;
import pages.HomePage;
import pages.components.Header;

public class HeaderTest extends BaseTest {
    private HomePage homePage;
    private Header header;
    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        header = new Header(driver);
    }
    //@BeforeTest
    @Test
    public void checkIfToolsQALogoOpensHomePage() {
        homePage.openUrl();
        String url = driver.getCurrentUrl();
        header.clickOnToolsQaLogo();
        Assertions.assertThat(url).isEqualTo("https://www.toolsqa.com/");
    }

}


