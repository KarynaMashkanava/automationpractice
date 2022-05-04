package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.SearchResultPage;
import utilities.Constants;

public class ProductSearchTest extends BaseTest {

    private LandingPage landingPage;

    @BeforeMethod
    public void beforeEachTest() {
        landingPage = new LandingPage(driver.get());
    }

    @Test
    @Description("Verify product search is for existing product")
    public void searchProductTest() {
        SearchResultPage searchResultPage = landingPage
                .typeSearchName(Constants.SEARCH_CRITERIA)
                .clickSearchButton();

        Assert.assertEquals(searchResultPage.getNumberOfSearchResults(), Integer.valueOf(2), "Number of results is not correct");
    }

    @Test
    @Description("Verify product warning message for empty search")
    public void searchEmptyTest() {
        SearchResultPage searchResultPage = landingPage
                .typeSearchName("")
                .clickSearchButton();

        Assert.assertEquals(searchResultPage.getWarningMessageText(), "Please enter a search keyword");
    }
}