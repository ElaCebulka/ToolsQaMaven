package tests;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.*;
import pages.HomePage;
import pages.components.RegistrationForm;

public class HomePageTest extends BaseTest {
    private HomePage homePage;
    private String expectedErrorFontColour = "#dc3545";

    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
    }

    //TQ-3 Filling registration form - 'Enroll yourself' button
    @Test
    public void fillRegistrationFormEnrollYourselfWithAllRequiredData() {
        homePage.openFormWithEnrollYourselfButton();
        homePage.fillTheForm(new RegistrationForm.FormBuilder()
                    .setFirstName("Anna")
                    .setLastName("Kowal")
                    .setEmail("anna@k.com")
                    .setMobile("123111222")
                    .setCity("Wroclaw")
                    .setCountry("Poland")
                    .setMessage("Message test")
                    .build());
        homePage.fillCaptcha();
        homePage.sendForm();
        Assertions.assertTrue(homePage.checkIfYourNotHumanPopupIsDisplayed());
    }

    //TQ-4 Filling registration form - Tutorials and Courses Grid
    @Test
    public void fillRegistrationFormEnrollYourselfWithWrongEmail() {
        homePage.openFormWithEnrollYourselfButton();
        homePage.fillTheForm(new RegistrationForm.FormBuilder()
                    .setFirstName("Anna")
                    .setLastName("Kowal")
                    .setEmail("aa")
                    .setMobile("123111222")
                    .setCity("Wroclaw")
                    .setCountry("Poland")
                    .build());
        homePage.sendForm();
        //email font colour is red
        Assertions.assertEquals(expectedErrorFontColour, homePage.checkColorOfFontInTheForm(homePage.getEmailBy()));
        //there is no popup that form was send
        Assertions.assertFalse(homePage.checkIfSendFormPopupIsDisplayed());
    }

    //TQ 8 Filling registration form - wrong data
    @Test
    public void fillRegistrationFormWithoutFirstName() {
        homePage.openFormWithEnrollYourselfButton();
        homePage.fillTheForm(new RegistrationForm.FormBuilder()
                    .setLastName("Kowal")
                    .setEmail("ana@aa.com")
                    .setMobile("aaaa")
                    .setCity("Wroclaw")
                    .setCountry("Poland")
                    .build());
        homePage.fillCaptcha();
        homePage.sendForm();
        Assertions.assertFalse(homePage.checkIfYourNotHumanPopupIsDisplayed());
    }

}
