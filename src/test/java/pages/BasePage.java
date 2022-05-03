package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    @FindBy(xpath = "//a[@class = 'login']")
    protected WebElement signInButton;

    @FindBy(xpath = "//div[@class = 'shopping_cart']")
    protected WebElement shoppingCartButton;

    @FindBy(xpath = "//a[@class = 'logout']")
    protected WebElement logOutButton;

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
}
