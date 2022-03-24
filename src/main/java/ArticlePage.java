import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage extends BasePage {
    //setUp
    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    static By enrollTodayAddBy = By.cssSelector("img[alt=\"Enroll in Selenium Training\"]");
    //static By enrollTodayAddBy = By.xpath("//img[@alt=\"Enroll in Selenium Training\"]/parent::a");
    static By goToRegistrationButtonBy = By.xpath("//a[contains(text(), \"Go To Registration\")]");

}
