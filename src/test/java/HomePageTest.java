import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        super.setupTest();
    }

    //TQ-3 Filling registration form - 'Enroll yourself' button
    @Test
    public void fillRegistrationFormEnrollYourself() {
        HomePage homepage = new HomePage(driver);
        homepage.openUrl();
        homepage.acceptCookies();
        homepage.clickOnElement(homepage.enrollYourselfButtonBy);
        homepage.fillTheForm(new Form.FormBuilder()
                .setFirstName("Anna")
                .setLastName("Kowal")
                .build());
    }

    //TQ-4 Filling registration form - Tutorials and Courses Grid
    @Test
    public void fillRegistrationFormTutorialsAndCourses() {
        HomePage homepage = new HomePage(driver);
        homepage.openUrl();
        homepage.clickOnElement(homepage.firstTutorialInGridBy);
        ArticlePage articlePage = new ArticlePage(driver);
        homepage.clickOnElement(articlePage.enrollTodayAddBy);
        homepage.clickOnElement(articlePage.goToRegistrationButtonBy);
        homepage.fillTheForm(new Form.FormBuilder()
                .setFirstName("Anna")
                .setLastName("Kowal")
                .setEmail("anna@k.com")
                .setMobile("123111222")
                .setCity("Wroclaw")
                .setCountry("Poland")
                .build());

    }
    //QT 8 Filling registration form - wrong data
    @Test
    public void fillRegistrationFormWrongData() {
        HomePage homepage = new HomePage(driver);
        homepage.openUrl();
        homepage.clickOnElement(homepage.firstTutorialInGridBy);
        driver.manage().window().fullscreen();
        homepage.clickOnElement(ArticlePage.enrollTodayAddBy);
        homepage.clickOnElement(ArticlePage.goToRegistrationButtonBy);
        homepage.fillTheForm(new Form.FormBuilder()
                .setFirstName("Anna")
                .setLastName("Kowal")
                .setMobile("aaaa")
                .build());
    }
}
