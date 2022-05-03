package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    @FindBy(xpath = "//a[@class = 'login']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class = 'shopping_cart']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//a[@class = 'logout']")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@class = 'header_user_info']/a[@title = 'View my customer account']")
    private WebElement myAccountHeaderLink;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public SignInPage clickSignIn() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public Boolean isLogOutButtonDisplayed() {
        return logOutButton.isDisplayed();
    }

    public BasePage logOut() {
        logOutButton.click();
        return this;
    }

    public Boolean isSignInButtonPresent() {
        return signInButton.isDisplayed();
    }
}
