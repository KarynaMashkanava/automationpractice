package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import utilities.Constants;

public class ProductSearchTest extends BaseTest {

    @Test
    public void searchProductTest() {
        SearchResultPage searchResultPage = page.get().typeSearchName(Constants.SEARCH_CRITERIA).clickSearchButton();
        Assert.assertEquals(searchResultPage.getNumberOfSearchResults(), Integer.valueOf(2), "Number of results is not correct");
    }

    @Test
    public void searchEmptyTest() {
        SearchResultPage searchResultPage = page.get().typeSearchName("").clickSearchButton();
        Assert.assertTrue(searchResultPage.warningMessageContainsExpectedWarning("Please enter a search keyword"));
    }
}
