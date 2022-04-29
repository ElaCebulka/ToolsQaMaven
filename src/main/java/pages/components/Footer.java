package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.SeleniumTrainingPage;
import pages.TutorialsPage;

public class Footer extends BasePage {
    TutorialsPage tutorialsPage = new TutorialsPage(driver);
    SeleniumTrainingPage seleniumTrainingPage = new SeleniumTrainingPage(driver);
    //setUp
    public Footer(WebDriver driver) {
        super(driver);
    }

    //Site links
    By siteLinkTutorialsBy = By.cssSelector("a[href=\"/selenium-training?q=footer\"]");

    //Popular tutorials
    By popularTutorialsSeleniumBy = By.xpath("//a[(text() = \"Selenium\")]");

    //Recent tutorials
    By testProjectBy = By.xpath("//a[(text() = \"Test Project\")]");

    //Other Articles
    By appiumBy = By.xpath("//a[(text() = 'Appium')]");

    //Find us
    By facebook = By.xpath("//span[(text() = \"Facebook\")]");

    public void clickOnAppiumLink(){
        driver.findElement(appiumBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(tutorialsPage.enrollTodayBy));
    }

    public void clickOnSeleniumLink(){
        driver.findElement(popularTutorialsSeleniumBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(tutorialsPage.enrollTodayBy));
    }

    public void clickOnSiteLinkTutorialsLink(){
        driver.findElement(siteLinkTutorialsBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(seleniumTrainingPage.goToRegistrationButtonBy));
    }

}
