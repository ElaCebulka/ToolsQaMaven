package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumTrainingPage extends BasePage{
    WebDriver driver;
    public By goToRegistrationButtonBy = By.xpath("//a[contains(text(), \"Go To Registration \")]");

    public SeleniumTrainingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void clickOnGoToRegistrationButton() {
        driver.findElement(goToRegistrationButtonBy).click();
    }

}
