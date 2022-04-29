package tests;

import static org.assertj.core.api.Assertions.*;
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
    @Test
    public void checkIfToolsQALogoOpensHomePage() {
        homePage.openUrl();
        header.clickOnToolsQaLogo();
        String url = driver.getCurrentUrl();
        assertThat(url).isEqualTo("https://www.toolsqa.com/");
    }

    @Test
    public void checkIfSeleniumTrainingButtonOpensCorrectPage() {
        homePage.openUrl();
        header.clickOnSeleniumTrainingTab();
        String url = driver.getCurrentUrl();
        assertThat(url).isEqualTo("https://www.toolsqa.com/selenium-training?q=headers");
    }

}


