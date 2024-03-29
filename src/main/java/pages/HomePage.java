package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.components.RegistrationForm;


public class HomePage extends BasePage {
    private final String url = "https://www.toolsqa.com/";
    By acceptCookiesButtonBy = By.cssSelector("button#accept-cookie-policy");
    By enrollYourselfButtonBy = By.cssSelector("a.btn.btn-primary-shadow.btn-block");

    //Form
    By firstNameFormBy = By.cssSelector("input#first-name");
    By lastNameFormBy = By.cssSelector("input#last-name");
    By emailFormBy = By.cssSelector("input#email");
    By mobileFormBy = By.cssSelector("input#mobile");
    By countryFormBy = By.cssSelector("select#country");
    By cityFormBy = By.cssSelector("input#city");
    By messageFormBy = By.cssSelector("textarea#message");
    By sendButtonFormBy = By.cssSelector("button.btn.btn-block.btn-primary");
    By captchaFieldBy = By.cssSelector("input#code");

    //Tutorial and curses grid
    By firstTutorialInGridBy = By.cssSelector("a[href=\"https://www.toolsqa.com/testproject-tutorial/\"]");

    //Latest Articles
    By latestArticlesButtonBy = By.xpath("//a[contains(text(), \"Latest Articles\")]");
    By articleInAGridBy = By.cssSelector("img.article__featured-image");

    //External links
    By youtubeSubscribeButtonBy = By.cssSelector("a.btn.btn-youtube");

    //setUp
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openUrl() {
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void acceptCookiesIfDisplayed() {
        try {
            driver.findElement(acceptCookiesButtonBy).click(); }
        catch (org.openqa.selenium.ElementClickInterceptedException e) {
        }
    }

    public void clickOnEnrollYourselfButton() {
        driver.findElement(enrollYourselfButtonBy).click();
    }
    public void clickOnFirstTutorialInGrid() {
        driver.findElement(firstTutorialInGridBy);
    }
    public void clickOnEnrollTodayAdd() {
        driver.findElement(ArticlePage.enrollTodayAddBy);
    }
    public void clickOnGoToRegistrationButton() {
        driver.findElement(ArticlePage.goToRegistrationButtonBy);
    }
    public void openFormWithEnrollYourselfButton() {
        openUrl();
        acceptCookiesIfDisplayed();
        clickOnEnrollYourselfButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstNameFormBy)));
    }

    public void openFormFromTutorialsAndCourses() {
        openUrl();
        acceptCookiesIfDisplayed();
        clickOnFirstTutorialInGrid();
        clickOnEnrollTodayAdd();
        clickOnGoToRegistrationButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstNameFormBy)));
    }

    public void selectCountryOnForm(String country){
        driver.findElement(countryFormBy);
        By countryValueFormBy = By.xpath("//option[contains(text(), '" + country +"')]");
        driver.findElement(countryValueFormBy);
    }

    public void fillTheForm(RegistrationForm form) {
        // scroll top - to avoid header covers FirsName input
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        if (form.getFirstName()!= null) {
            driver.findElement(firstNameFormBy).sendKeys(form.getFirstName());
        }
        if (form.getLastName()!= null) {
            driver.findElement(lastNameFormBy).sendKeys(form.getLastName());
        }
        if (form.getEmail()!= null) {
            driver.findElement(emailFormBy).sendKeys(form.getEmail());
        }
        if (form.getMobile()!= null) {
            driver.findElement(mobileFormBy).sendKeys(form.getMobile());
        }
        if (form.getCountry()!= null) {
            selectCountryOnForm(form.getCountry());
        }
        if (form.getCity()!= null) {
            driver.findElement(cityFormBy).sendKeys(form.getCity());
        }
        if (form.getMessage()!= null) {
            driver.findElement(messageFormBy).sendKeys(form.getMessage());
        }
    }
    public void fillCaptcha() {driver.findElement(captchaFieldBy).sendKeys("aaa");}
    public void sendForm() {
        driver.findElement(sendButtonFormBy).click();
    }

    public String checkColorOfFontInTheForm(By by) {
        String color = driver.findElement(by).getCssValue ("color");
        return Color.fromString(color).asHex();
    }

    public boolean checkIfSendFormPopupIsDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert.alert-success.show")));
            return true;
        }
        catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean checkIfYourNotHumanPopupIsDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert.alert-error.show")));
            return true;
        }
        catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public By getEmailBy() {
        return emailFormBy;
    }
}
