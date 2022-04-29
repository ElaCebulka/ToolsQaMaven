package tests;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SeleniumTrainingPage;
import pages.components.Header;
import pages.components.RegistrationForm;

public class SeleniumTrainingTest extends BaseTest{
    private Header header;
    private SeleniumTrainingPage seleniumTrainingPage;
    private HomePage homePage;
    @BeforeClass
    public void setup() { header = new Header(driver);
        seleniumTrainingPage = new SeleniumTrainingPage(driver);
        homePage = new HomePage(driver);
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
