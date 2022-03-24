import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
        homePage.openFormWithEnrollYourselfButton();
        homePage.fillTheForm(new Form.FormBuilder()
                    .setFirstName("Anna")
                    .setLastName("Kowal")
                    .build());
        homePage.sendForm();
    }

    //TQ-4 Filling registration form - Tutorials and Courses Grid
    @Test
    public void fillRegistrationFormTutorialsAndCourses() {
        homePage.openFormFromTutorialsAndCourses();
        homePage.fillTheForm(new Form.FormBuilder()
                    .setFirstName("Anna")
                    .setLastName("Kowal")
                    .setEmail("anna@k.com")
                    .setMobile("123111222")
                    .setCity("Wroclaw")
                    .setCountry("Poland")
                    .build());
        homePage.sendForm();

    }
    //QT 8 Filling registration form - wrong data
    @Test
    public void fillRegistrationFormWrongData() {
        homePage.openFormFromTutorialsAndCourses();
        homePage.fillTheForm(new Form.FormBuilder()
                    .setFirstName("Anna")
                    .setLastName("Kowal")
                    .setEmail("ana@aa.com")
                    .setMobile("aaaa")
                    .setCity("Wroclaw")
                    .setCountry("Poland")
                    .build());
        homePage.sendForm();
    }

}
