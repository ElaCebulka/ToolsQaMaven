package tests;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SeleniumTrainingPage;
import pages.components.Header;
import pages.components.RegistrationForm;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTrainingTest extends BaseTest{
    private Header header;
    private SeleniumTrainingPage seleniumTrainingPage;
    private HomePage homePage;
    @BeforeClass
    public void setup() { header = new Header(driver);
        seleniumTrainingPage = new SeleniumTrainingPage(driver);
        homePage = new HomePage(driver);
    }
    @Test
    public void checkIfGoToRegistrationButtonOpensCorrectPage() {
        homePage.openUrl();
        header.clickOnSeleniumTrainingTab();
        seleniumTrainingPage.clickOnGoToRegistrationButton();
        String url = driver.getCurrentUrl();
        assertThat(url).isEqualTo("https://www.toolsqa.com/selenium-training?q=headers#enroll-form");
    }
}
