package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TutorialsPage;
import pages.components.Footer;

import static org.assertj.core.api.Assertions.assertThat;

public class TutorialsTest extends BaseTest{
    HomePage homePage;
    TutorialsPage tutorialsPage;
    Footer footer;
    @BeforeClass
    public void setup() {
        tutorialsPage = new TutorialsPage(driver);
        homePage = new HomePage(driver);
        footer = new Footer(driver);
    }
    @Test
    public void checkIfGoToRegistrationButtonOpensCorrectPage() {
        homePage.openUrl();
        homePage.acceptCookiesIfDisplayed();
        footer.clickOnAppiumLink();
        tutorialsPage.clickOnEnrollTodayAdd();
        String url = driver.getCurrentUrl();
        assertThat(url).isEqualTo("https://www.toolsqa.com/selenium-training?q=leftad");
    }
}
