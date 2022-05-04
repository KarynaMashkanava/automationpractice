package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.CheckoutShippingPage;
import pages.LandingPage;
import pages.OrderConfirmationPage;
import utilities.Constants;

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

    @Test
    public void addProductToCartTest() {
        Assert.assertTrue(checkOutPage.isProductNameCorrect(Constants.SEARCH_CRITERIA_SINGLE_ITEM));
    }

    @Test
    public void deleteItemFromCart() {
        checkOutPage.deleteItemFromCart();
        Assert.assertEquals(checkOutPage.getWarningMessageText(), "Your shopping cart is empty.");
    }

    @Test
    public void validateErrorWhenAgreeWithTermsNotChecked() {
        CheckoutShippingPage checkoutShippingPage = checkOutPage
                .clickProceedToCheckOutPage()
                .proceedToCheckout()
                .clickProceedToCheckoutPageWithError();

        Assert.assertEquals(checkoutShippingPage.getTermsErrorMessage(), "You must agree to the terms of service before continuing.");
    }

    @Test
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
