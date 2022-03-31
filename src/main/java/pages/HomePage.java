package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

    public void acceptCookies() {
        wait.until(ExpectedConditions.presenceOfElementLocated(acceptCookiesButtonBy));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("e");
        }

        clickOnElement(acceptCookiesButtonBy);
    }

    public void clickOnEnrollYourselfButton() {
        clickOnElement(enrollYourselfButtonBy);
    }
    public void clickOnFirstTutorialInGrid() {
        clickOnElement(firstTutorialInGridBy);
    }
    public void clickOnEnrollTodayAdd() {
        clickOnElement(ArticlePage.enrollTodayAddBy);
    }
    public void clickOnGoToRegistrationButton() {
        clickOnElement(ArticlePage.goToRegistrationButtonBy);
    }
    public void openFormWithEnrollYourselfButton() {
        openUrl();
        acceptCookies();
        clickOnEnrollYourselfButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstNameFormBy)));
    }

    public void openFormFromTutorialsAndCourses() {
        openUrl();
        acceptCookies();
        clickOnFirstTutorialInGrid();
        clickOnEnrollTodayAdd();
        clickOnGoToRegistrationButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstNameFormBy)));
    }

    public void selectCountryOnForm(String country){
        clickOnElement(countryFormBy);
        By countryValueFormBy = By.xpath("//option[contains(text(), '" + country +"')]");
        clickOnElement(countryValueFormBy);
        //System.out.println(driver.findElement(By.xpath("//select[@class=\"upcoming__registration--input\"]/parent::div")).getText());
    }

    public void fillTheForm(RegistrationForm form) {
        // scroll top - to avoid header covers FirsName input
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //scroll to see FirsName input
        scrollToSeeElement(driver.findElement(firstNameFormBy));

        if (form.getFirstName()!= null) {
            clickOnElement(firstNameFormBy).sendKeys(form.getFirstName());
        }
        if (form.getLastName()!= null) {
            clickOnElement(lastNameFormBy).sendKeys(form.getLastName());
        }
        if (form.getEmail()!= null) {
            clickOnElement(emailFormBy).sendKeys(form.getEmail());
        }
        if (form.getMobile()!= null) {
            clickOnElement(mobileFormBy).sendKeys(form.getMobile());
        }
        if (form.getCountry()!= null) {
            selectCountryOnForm(form.getCountry());
        }
        if (form.getCity()!= null) {
            clickOnElement(cityFormBy).sendKeys(form.getCity());
        }
        if (form.getMessage()!= null) {
            clickOnElement(messageFormBy).sendKeys(form.getMessage());
        }
    }
    public void sendForm() {
        clickOnElement(sendButtonFormBy);
    }
}
