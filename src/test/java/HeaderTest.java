import org.assertj.core.api.Assertions;
import org.testng.annotations.*;

public class HeaderTest extends BaseTest {


    //@BeforeTest
    @Test
    public void checkIfToolsQALogoOpensHomePage() {
        //trzeba przeniesc poza metode
        Header header = new Header(driver);
        HomePage homePage = new HomePage(driver);
        //
        homePage.openUrl();
        String url = driver.getCurrentUrl();
        header.clickOnToolsQaLogo();
        Assertions.assertThat(url).isEqualTo("https://www.toolsqa.com/");
    }

}


