import org.assertj.core.api.Assertions;
import org.testng.annotations.*;

public class HeaderTest extends BaseTest {

    @BeforeTest
    public void setUp(){
        super.setupTest();
    }

    @Test
    public void checkIfToolsQALogoOpensHomePage() {
        Header header = new Header(driver);
        BasePage.openUrl();
        String url = driver.getCurrentUrl();
        header.clickOnElement(header.toolsQaLogoBy);
        System.out.println(url);
        Assertions.assertThat(url).isEqualTo("https://www.toolsqa.com/");
    }

}


