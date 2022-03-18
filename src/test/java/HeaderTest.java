import org.assertj.core.api.Assertions;
import org.testng.annotations.*;

public class HeaderTest extends BaseTest {

    /*@BeforeTest
    public void setUp(){
        super.setupTest();
    }*/

    @Test
    public void checkIfToolsQALogoOpensHomePage() {
        HomePage hompage = new HomePage(driver);
        Header header = new Header(driver);
        hompage.openUrl();
        String url = driver.getCurrentUrl();
        header.clickOnElement(header.toolsQaLogoBy);
        System.out.println(url);
        Assertions.assertThat(url).isEqualTo("https://www.toolsqa.com/");
    }

}


