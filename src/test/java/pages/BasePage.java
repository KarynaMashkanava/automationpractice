package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j
public class BasePage {

    @FindBy(xpath = "//a[@class = 'login']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//a[@class = 'logout']")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@class = 'header_user_info']/a[@title = 'View my customer account']")
    private WebElement myAccountHeaderLink;

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement submitSearchElement;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public SignInPage clickSignIn() {
        log.info("click sign in button");
        signInButton.click();
        return new SignInPage(driver);
    }

    public Boolean isLogOutButtonDisplayed() {
        return logOutButton.isDisplayed();
    }

    public BasePage logOut() {
        log.info("click log out button");
        logOutButton.click();
        return this;
    }

    public Boolean isSignInButtonPresent() {
        return signInButton.isDisplayed();
    }

    public BasePage typeSearchName(String name) {
        searchInput.sendKeys(name);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        submitSearchElement.click();
        return new SearchResultPage(driver);
    }

    public CheckOutPage openCartPage() {
        shoppingCartButton.click();
        return new CheckOutPage(driver);
    }
}
