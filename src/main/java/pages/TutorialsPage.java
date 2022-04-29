package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TutorialsPage extends BasePage{
    private SeleniumTrainingPage seleniumTrainingPage = new SeleniumTrainingPage(driver);

    public TutorialsPage(WebDriver driver) {
        super(driver);
    }

    public By enrollTodayBy = By.cssSelector("img.article-body__left-menu--training-ad");

    public void clickOnEnrollTodayAdd() {
        driver.findElement(enrollTodayBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(seleniumTrainingPage.goToRegistrationButtonBy));
    }
}
