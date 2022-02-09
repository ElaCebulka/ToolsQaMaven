import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Form extends HomePage{
    public Form(WebDriver driver) {
        super(driver);
    }
    //Test data
    String firstNameForm = "Anna";
    String lastNameForm = "Kowal";
    String emailForm = "Anna";
    String country = "Poland";
    By countryValueFormBy = By.xpath("//option[contains(text(), " + country +")]");

}
