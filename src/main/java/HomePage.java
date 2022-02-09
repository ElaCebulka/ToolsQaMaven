import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

;

public class HomePage extends BasePage {


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
    }

    public void acceptCookies() {
        //odkomentowac po przebudowie
        //wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButtonBy));
        clickOnElement(acceptCookiesButtonBy);
    }

    public void selectCountryOnForm(String country){
        Form form = new Form(driver);
        clickOnElement(countryFormBy);
        clickOnElement(form.countryValueFormBy);
    }

    public void fillTheForm() {
        Form form = new Form(driver);

        System.out.println("1");
        scrollToSeeElement(driver.findElement(firstNameFormBy));
        clickOnElement(firstNameFormBy).sendKeys("Anna");
        System.out.println("2");
        clickOnElement(lastNameFormBy).sendKeys("Kowal");
        System.out.println("3");
        clickOnElement(emailFormBy).sendKeys("anna@kowal.com");
        System.out.println("4");
        clickOnElement(mobileFormBy).sendKeys("666555444");
        System.out.println("5");
        selectCountryOnForm(form.country);
        System.out.println("7");
        clickOnElement(cityFormBy).sendKeys("Wroclaw");
        System.out.println("8");
        clickOnElement(messageFormBy).sendKeys("Test Message");
        System.out.println("9");
        clickOnElement(sendButtonFormBy);
    }


}
