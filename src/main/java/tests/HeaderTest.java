package tests;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SeleniumTrainingPage;
import pages.components.Header;
import pages.components.RegistrationForm;

public class HeaderTest extends BaseTest {
    private HomePage homePage;
    private Header header;
    private SeleniumTrainingPage seleniumTrainingPage;
    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        header = new Header(driver);
        seleniumTrainingPage = new SeleniumTrainingPage(driver);
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
    //TQ1 Filling registration form - 'go to registration' button
    @Test
    public void fillRegistrationFormGoToRegistrationButtonCorrectData() {
        seleniumTrainingPage.openUrl();
        header.clickOnSeleniumTrainingTab();
        seleniumTrainingPage.clickOnGoToRegistrationButton();
        homePage.fillTheForm(new RegistrationForm.FormBuilder()
                .setFirstName("Anna")
                .setLastName("Kowal")
                .setEmail("aa@atest.pl")
                .setMobile("123111222")
                .setCity("Wroclaw")
                .setCountry("Finland")
                .setMessage("test message")
                .build());
        homePage.fillCaptcha();
        homePage.sendForm();
        Assertions.assertTrue(homePage.checkIfYourNotHumanPopupIsDisplayed());
    }

    //TQ2 Filling registration form - scroll down till the form
    @Test
    public void fillRegistrationWithoutGoToRegistrationButtonCorrectData() {
        seleniumTrainingPage.openUrl();
        header.clickOnSeleniumTrainingTab();
        homePage.fillTheForm(new RegistrationForm.FormBuilder()
                .setFirstName("Anna")
                .setLastName("Kowal")
                .setEmail("aa@atest.pl")
                .setMobile("123111222")
                .setCity("Wroclaw")
                .setCountry("Finland")
                .setMessage("test message")
                .build());
        homePage.fillCaptcha();
        homePage.sendForm();
        Assertions.assertTrue(homePage.checkIfYourNotHumanPopupIsDisplayed());
    }

    //TQ3 Filling registration form - empty data
    @Test
    public void fillRegistrationWithoutGoToRegistrationButtonEmptyData() {
        seleniumTrainingPage.openUrl();
        header.clickOnSeleniumTrainingTab();
        homePage.fillCaptcha();
        homePage.sendForm();
        Assertions.assertFalse(homePage.checkIfYourNotHumanPopupIsDisplayed());
    }
}


