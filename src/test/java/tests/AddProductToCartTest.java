package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import utilities.Constants;

public class AddProductToCartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        CheckOutPage checkOutPage = page.get()
                .clickSignIn()
                .signIn(USER)
                .typeSearchName(Constants.SEARCH_CRITERIA_SINGLE_ITEM)
                .clickSearchButton()
                .clickAddProductToCartForNthElement(0)
                .clickClosePopUpPage()
                .openCartPage();

        Assert.assertTrue(checkOutPage.isProductNameCorrect(Constants.SEARCH_CRITERIA_SINGLE_ITEM));
    }
}
