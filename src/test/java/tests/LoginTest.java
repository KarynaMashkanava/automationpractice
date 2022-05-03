package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MyAccountPage;
import pages.SignInPage;
import utilities.Constants;

public class LoginTest extends BaseTest {

    private LandingPage page;

    @BeforeMethod
    public void beforeEachTest() {
        page = new LandingPage(driver);
    }

    @Test
    public void loginWithValidCredentialsTest() {
        User user = User.builder()
                .email(Constants.VALID_USERNAME)
                .password(Constants.VALID_PASSWORD)
                .build();

        MyAccountPage accountPage = page.clickSignIn().signIn(user);
        Assert.assertTrue(accountPage.isLogOutButtonDisplayed(), "User is not logged in!");
    }

    @Test(dataProvider = "invalid data")
    public void loginInvalidCredentialsTest(User user, String expectedError) {
        SignInPage signInPage = page.clickSignIn();
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
