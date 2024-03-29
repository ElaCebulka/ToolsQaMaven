package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.SeleniumTrainingPage;

public class Header extends BasePage {
    private By toolsQaLogoBy = By.className("tools-qa-header__logo");
    SeleniumTrainingPage seleniumTrainingPage = new SeleniumTrainingPage(driver);
    //Tutorials menu
    String tutorialCategory1 = "QA Practices";
    String tutorialCategory2 = "Agile & Scrum";
    By tutorialsHeaderMenuBy = By.className("navbar__tutorial-menu");
    By tutorialCategory1By = By.xpath("//span[contains(text()," + tutorialCategory1 + ")]");
    By tutorialCategory2By = By.cssSelector("li a[title=" + tutorialCategory2 + "]");

    By homeHeaderMenuBy = By.xpath("//a[contains(text(), \"Home\")]");
    By demoSiteHeaderMenuBy = By.xpath("//a[contains(text(), \"Demo Site\")]");
    By seleniumTrainingHeaderMenuBy = By.xpath("//a[contains(text(), \"Selenium Training\")]");
    By AboutHeaderMenuBy = By.xpath("//a[contains(text(), \"About\")]");
    By searchHeaderMenuBy = By.cssSelector("div.navbar__search input");
    By searchIconBy = By.cssSelector("div.navbar__search icon");

    //setUp
    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnToolsQaLogo() {
        driver.findElement(toolsQaLogoBy).click();
    }

    public void searchTraining(String trainingName) {
        driver.findElement(searchHeaderMenuBy).sendKeys(trainingName);
        driver.findElement(searchIconBy);
    }

    public void openTutorialFromMenu() {
        driver.findElement(tutorialsHeaderMenuBy);
        driver.findElement(tutorialCategory1By);
        driver.findElement(tutorialCategory2By);
    }

    public void clickOnSeleniumTrainingTab() {
        driver.findElement(seleniumTrainingHeaderMenuBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(seleniumTrainingPage.goToRegistrationButtonBy));
    }

    //@Override
    public boolean isLoaded() {

        return false;
    }

}
