package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id = 'center_column']/div[@class = 'alert alert-danger']")
    private WebElement authErrorElement;

    public SignInPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(emailInput));
    }

    public SignInPage typeEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public SignInPage typePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return this;
    }

    public MyAccountPage signIn(User user) {
        typeEmail(user.getEmail());
        typePassword(user.getPassword());
        clickSignInButton();
        return new MyAccountPage(driver);
    }

    public SignInPage waitForAuthErrorElement() {
        wait.until(ExpectedConditions.visibilityOf(authErrorElement));
        return this;
    }

    public Boolean verifyAuthErrorContainsText(String expectedError) {
        return authErrorElement.getText().contains(expectedError);
    }
}
