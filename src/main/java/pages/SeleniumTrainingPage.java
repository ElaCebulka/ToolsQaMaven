package pages;

import org.openqa.selenium.WebDriver;

public class SeleniumTrainingPage extends BasePage{
    WebDriver driver;
    public SeleniumTrainingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
}
