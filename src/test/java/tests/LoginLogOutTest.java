package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MyAccountPage;
import pages.SignInPage;
import utilities.Constants;

public class LoginLogOutTest extends BaseTest {

    private final ThreadLocal<LandingPage> page = new ThreadLocal<>();
    private final User USER = User.builder()
            .email(Constants.VALID_USERNAME)
            .password(Constants.VALID_PASSWORD)
            .build();

    @BeforeMethod
    public void beforeEachTest() {
        page.set(new LandingPage(driver.get()));
    }

    @Test(priority = 0)
    @Description("Verify user is able to log in with valid data")
    public void loginWithValidCredentialsTest() {
        MyAccountPage accountPage = page.get().clickSignIn().signIn(USER);
        Assert.assertTrue(accountPage.isLogOutButtonDisplayed(), "User is not logged in!");
    }

    @Test(priority = 1)
    @Description("Verify user is able to log out")
    public void logOutTest() {;
        page.get().clickSignIn().signIn(USER).logOut();
        Assert.assertTrue(page.get().isSignInButtonPresent(), "User did not get logged out");
    }

    @Test(dataProvider = "invalid data", priority = 3)
    @Description("Verify error message when user logs in with invalid data")
    public void loginInvalidCredentialsTest(User user, String expectedError) {
        SignInPage signInPage = page.get().clickSignIn();
        signInPage
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInButton();
        Boolean isErrorCorrect = signInPage.waitForAuthErrorElement().verifyAuthErrorContainsText(expectedError);
        Assert.assertTrue(isErrorCorrect, "Error is incorrect!");
    }

    @DataProvider(name = "invalid data")
    private Object[][] getInvalidTestUsers() {
        return new Object[][] {
                {User.builder().email("invalidEmail@gmali.com").password("Test1234!").build(), "Authentication failed."},
                {User.builder().email("").password("Test1234!").build(), "An email address required."},
                {User.builder().email(Constants.VALID_USERNAME).password("invalid!").build(), "Authentication failed."},
                {User.builder().email(Constants.VALID_USERNAME).password("").build(), "Password is required."},
        };
    }
}
