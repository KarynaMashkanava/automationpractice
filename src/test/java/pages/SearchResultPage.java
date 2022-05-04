package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Log4j
public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[@class = 'heading-counter']")
    private WebElement numberOfResultsFound;

    @FindBy(xpath = "//ul[@class = 'product_list grid row']/li[contains(@class, 'block_product')]")
    private List<WebElement> productsOnPage;

    @FindBy(xpath = "//a[@title = 'Add to cart']")
    private List<WebElement> addProductToCartElements;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(numberOfResultsFound));
    }

    public Integer getNumberOfSearchResults() {
        log.info("getting number of search results");
        return productsOnPage.size();
    }

    public ProductAddedToCartPopUp clickAddProductToCartForNthElement(Integer position) {
        log.info("hit add to cart");
        Actions actions = new Actions(driver);
        actions.moveToElement(productsOnPage.get(position)).build().perform();
        addProductToCartElements.get(position).click();
        return new ProductAddedToCartPopUp(driver);
    }
}
