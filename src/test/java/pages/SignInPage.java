package pages;

import lombok.extern.log4j.Log4j;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
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
        log.info("type email: " + email);
        emailInput.sendKeys(email);
        return this;
    }

    public SignInPage typePassword(String password) {
        log.info("type pass: " + password);
        passwordInput.sendKeys(password);
        return this;
    }

    public SignInPage clickSignInButton() {
        log.info("click sing in button");
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
        log.info("waiting for error element..");
        wait.until(ExpectedConditions.visibilityOf(authErrorElement));
        return this;
    }

    public Boolean verifyAuthErrorContainsText(String expectedError) {
        return authErrorElement.getText().contains(expectedError);
    }
}
