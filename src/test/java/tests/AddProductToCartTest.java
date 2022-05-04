package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.CheckoutShippingPage;
import pages.LandingPage;
import pages.OrderConfirmationPage;
import utilities.Constants;
import utilities.Retry;

public class AddProductToCartTest extends BaseTest {

    private LandingPage landingPage;
    private CheckOutPage checkOutPage;

    @BeforeMethod
    public void beforeEachMethod() {
        landingPage = new LandingPage(driver.get());
        checkOutPage = landingPage
                .clickSignIn()
                .signIn(USER)
                .typeSearchName(Constants.SEARCH_CRITERIA_SINGLE_ITEM)
                .clickSearchButton()
                .clickAddProductToCartForNthElement(0)
                .clickClosePopUpPage()
                .openCartPage();
    }

    @Test(priority = 0, retryAnalyzer = Retry.class)
    @Description("Verify user is able to add product to cart")
    public void addProductToCartTest() {
        Assert.assertTrue(checkOutPage.isProductNameCorrect(Constants.SEARCH_CRITERIA_SINGLE_ITEM));
    }

    @Test(priority = 1, retryAnalyzer = Retry.class)
    @Description("Verify user is able to delete product from cart")
    public void deleteItemFromCart() {
        checkOutPage.deleteItemFromCart();
        Assert.assertEquals(checkOutPage.getWarningMessageText(), "Your shopping cart is empty.");
    }

    @Test(priority = 2, retryAnalyzer = Retry.class)
    @Description("Validate error message when accept terms is not checked")
    public void validateErrorWhenAgreeWithTermsNotChecked() {
        CheckoutShippingPage checkoutShippingPage = checkOutPage
                .clickProceedToCheckOutPage()
                .proceedToCheckout()
                .clickProceedToCheckoutPageWithError();

        Assert.assertEquals(checkoutShippingPage.getTermsErrorMessage(), "You must agree to the terms of service before continuing.");
    }

    @Test(priority = 3, retryAnalyzer = Retry.class)
    @Description("End-to-end scenario to create order")
    public void createOrderTest() {
        OrderConfirmationPage orderConfirmationPage = checkOutPage
                .clickProceedToCheckOutPage()
                .proceedToCheckout()
                .checkAgreeWithTerms()
                .clickProceedToCheckoutPage()
                .selectBankWireOption()
                .confirmOrder();

        Assert.assertTrue(orderConfirmationPage.validateConfirmationContainsExpectedText("Your order on My Store is complete."), "Order message is incorrect, please validate order confirmation!");
    }
}
