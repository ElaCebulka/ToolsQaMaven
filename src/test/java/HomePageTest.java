import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private HomePage homePage;
    private Header header;
    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        header = new Header(driver);
    }
    //TQ-3 Filling registration form - 'Enroll yourself' button
    @Test
    public void fillRegistrationFormEnrollYourself() {
        homePage.openUrl();
        homePage.acceptCookies();
        homePage.clickOnElement(homePage.enrollYourselfButtonBy);
        homePage.fillTheForm(new Form.FormBuilder()
                    .setFirstName("Anna")
                    .setLastName("Kowal")
                    .build());
    }

    //TQ-4 Filling registration form - Tutorials and Courses Grid
    @Test
    public void fillRegistrationFormTutorialsAndCourses() {
        homePage.openUrl();
        homePage.clickOnElement(homePage.firstTutorialInGridBy);
        homePage.clickOnElement(ArticlePage.enrollTodayAddBy);
        driver.manage().window().fullscreen();
        homePage.clickOnElement(ArticlePage.goToRegistrationButtonBy);
        homePage.fillTheForm(new Form.FormBuilder()
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
        homePage.openUrl();
        homePage.clickOnElement(homePage.firstTutorialInGridBy);
        driver.manage().window().fullscreen();
        homePage.clickOnElement(ArticlePage.enrollTodayAddBy);
        homePage.clickOnElement(ArticlePage.goToRegistrationButtonBy);
        homePage.fillTheForm(new Form.FormBuilder()
                    .setFirstName("Anna")
                    .setLastName("Kowal")
                    .setEmail("ana@aa.com")
                    .setMobile("aaaa")
                    .setCity("Wroclaw")
                    .setCountry("Poland")
                    .build());
    }
}
