import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public final String url = "https://www.toolsqa.com/";
    WebDriver driver;

    By acceptCookiesButtonBy = By.cssSelector("button#accept-cookie-policy");
    By enrollYourselfButtonBy = By.cssSelector("a[href=\"/selenium-training#enroll-form\"]");

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
        driver.manage().window().fullscreen();
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.presenceOfElementLocated(acceptCookiesButtonBy));
        clickOnElement(acceptCookiesButtonBy);
    }

    public void selectCountryOnForm(String country){
        clickOnElement(countryFormBy);
        By countryValueFormBy = By.xpath("//option[contains(text(), " + country +")]");
        clickOnElement(countryValueFormBy);
    }

    public void fillTheForm(Form form) {
        System.out.println("1");
        scrollToSeeElement(driver.findElement(firstNameFormBy));
        clickOnElement(firstNameFormBy).sendKeys(form.getFirstName());
        System.out.println("2");
        clickOnElement(lastNameFormBy).sendKeys(form.getLastName());
        System.out.println("3");
        clickOnElement(emailFormBy).sendKeys(form.getEmail());
        System.out.println("4");
        clickOnElement(mobileFormBy).sendKeys(form.getMobile());
        System.out.println("5");
        selectCountryOnForm(form.getCountry());
        System.out.println("7");
        clickOnElement(cityFormBy).sendKeys(form.getCity());
        System.out.println("8");
        clickOnElement(messageFormBy).sendKeys(form.getMessage());
        System.out.println("9");
        clickOnElement(sendButtonFormBy);
    }

}
