import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {
    static By toolsQaLogoBy = By.className("tools-qa-header__logo");

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
        this.driver=driver;
    }

   public void searchTraining(String trainingName) {
        clickOnElement(searchHeaderMenuBy).sendKeys(trainingName);
        clickOnElement(searchIconBy);
    }

    public void openTutorialFromMenu() {
        clickOnElement(tutorialsHeaderMenuBy);
        clickOnElement(tutorialCategory1By);
        clickOnElement(tutorialCategory2By);
    }

    //@Override
    public boolean isLoaded() {

        return false;
    }

}
