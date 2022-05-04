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
import utilities.Retry;

public class LoginLogOutTest extends BaseTest {

    private LandingPage landingPage;

    @BeforeMethod
    public void beforeEachTest() {
        landingPage = new LandingPage(driver.get());
    }

    @Test(priority = 0, retryAnalyzer = Retry.class)
    @Description("Verify user is able to log in with valid data")
    public void loginWithValidCredentialsTest() {
        MyAccountPage accountPage = landingPage
                .clickSignIn()
                .signIn(USER);

        Assert.assertTrue(accountPage.isLogOutButtonDisplayed(), "User is not logged in!");
    }

    @Test(priority = 1, retryAnalyzer = Retry.class)
    @Description("Verify user is able to log out")
    public void logOutTest() {;
        landingPage
                .clickSignIn()
                .signIn(USER)
                .logOut();

        Assert.assertTrue(landingPage.isSignInButtonPresent(), "User did not get logged out");
    }

    @Test(dataProvider = "invalid data", priority = 3, retryAnalyzer = Retry.class)
    @Description("Verify error message when user logs in with invalid data")
    public void loginInvalidCredentialsTest(User user, String expectedError) {
        SignInPage signInPage = landingPage.clickSignIn();
        signInPage
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickSignInButton();
        Boolean isErrorCorrect = signInPage
                .waitForAuthErrorElement()
                .verifyAuthErrorContainsText(expectedError);
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
