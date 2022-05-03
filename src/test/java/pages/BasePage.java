package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(xpath = "//a[@class = 'login']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class = 'shopping_cart']")
    private WebElement shoppingCartButton;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected SignInPage clickSignIn() {
        signInButton.click();
        return new SignInPage();
    }
}
