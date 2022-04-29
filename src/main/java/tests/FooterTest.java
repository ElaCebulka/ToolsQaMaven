package tests;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TutorialsPage;
import pages.components.Footer;
import pages.components.RegistrationForm;

import static org.assertj.core.api.Assertions.assertThat;

public class FooterTest extends BaseTest{
    Footer footer;
    HomePage homePage;
    TutorialsPage tutorialsPage;

    @BeforeClass
    public void setUp() {
        footer = new Footer(driver);
        homePage = new HomePage(driver);
        tutorialsPage = new TutorialsPage(driver);
    }

    @Test
    public void checkIfTutorialsPageOpensFromFooterAppiumLink() {
        homePage.openUrl();
        homePage.acceptCookiesIfDisplayed();
        footer.clickOnAppiumLink();
        String url = driver.getCurrentUrl();
        assertThat(url).isEqualTo("https://www.toolsqa.com/appium-studio/appium-studio-tutorial/");
    }

    @Test
    public void checkIfTutorialsPageOpensFromFooterSeleniumLink() {
        homePage.openUrl();
        homePage.acceptCookiesIfDisplayed();
        footer.clickOnSeleniumLink();
        String url = driver.getCurrentUrl();
        assertThat(url).isEqualTo("https://www.toolsqa.com/selenium-webdriver/selenium-tutorial/");
    }

    @Test
    public void checkIfTutorialsPageOpensFromSiteLink() {
        homePage.openUrl();
        homePage.acceptCookiesIfDisplayed();
        footer.clickOnSiteLinkTutorialsLink();
        String url = driver.getCurrentUrl();
        assertThat(url).isEqualTo("https://www.toolsqa.com/selenium-training?q=footer");
    }

    //TQ5 Filling registration form footer - other articles
    @Test
    public void fillRegistrationFormGoingFromAppiumLink() {
        homePage.openUrl();
        homePage.acceptCookiesIfDisplayed();
        footer.clickOnAppiumLink();
        tutorialsPage.clickOnEnrollTodayAdd();
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

    //TQ6 Filling registration form footer - popular tutorials
    @Test
    public void fillRegistrationFormGoingFromSeleniumLink() {
        homePage.openUrl();
        homePage.acceptCookiesIfDisplayed();
        footer.clickOnSeleniumLink();
        tutorialsPage.clickOnEnrollTodayAdd();
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

    //TQ9 Filling registration form footer - mandatory field empty
    @Test
    public void fillRegistrationFormGoingFromSeleniumLinkFirstNameEmpty() {
        homePage.openUrl();
        homePage.acceptCookiesIfDisplayed();
        footer.clickOnSeleniumLink();
        tutorialsPage.clickOnEnrollTodayAdd();
        homePage.fillTheForm(new RegistrationForm.FormBuilder()
                .setLastName("Kowal")
                .setEmail("aa@atest.pl")
                .setMobile("123111222")
                .setCity("Wroclaw")
                .setCountry("Finland")
                .setMessage("test message")
                .build());
        homePage.fillCaptcha();
        homePage.sendForm();
        Assertions.assertFalse(homePage.checkIfYourNotHumanPopupIsDisplayed());
    }
}
