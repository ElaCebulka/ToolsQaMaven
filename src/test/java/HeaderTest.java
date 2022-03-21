import org.assertj.core.api.Assertions;
import org.testng.annotations.*;

public class HeaderTest extends BaseTest {
    //Header header = new Header(driver);
    HomePage homePage;
    private Header header;
    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        header = new Header(driver);
    }
    //@BeforeTest
    @Test
    public void checkIfToolsQALogoOpensHomePage() {
        //trzeba przeniesc poza metode

        //
        homePage.openUrl();
        String url = driver.getCurrentUrl();
        header.clickOnElement(header.toolsQaLogoBy);
        System.out.println(url);
        Assertions.assertThat(url).isEqualTo("https://www.toolsqa.com/");
    }

}


