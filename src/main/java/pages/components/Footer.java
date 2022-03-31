package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Footer extends BasePage {
    //setUp
    public Footer(WebDriver driver) {
        super(driver);
    }

    //Site links
    By siteLinkTutorialsBy = By.cssSelector("//a[contains(text(), \"Tutorials\")]");

    //Popular tutorials
    By popularTutorialsBy = By.cssSelector("//a[(text() = \"Selenium\")]");

    //Recent tutorials
    By testProjectBy = By.cssSelector("//a[(text() = \"Test Project\")]");

    //Other Articles
    By AppiumBy = By.cssSelector("//a[(text() = \"Appium\")]");

    //Find us
    By Facebook = By.cssSelector("//span[(text() = \"Facebook\")]");
}
