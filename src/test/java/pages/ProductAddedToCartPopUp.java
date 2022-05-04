package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
public class ProductAddedToCartPopUp extends BasePage {

    @FindBy(className = "cross")
    private WebElement closePopUp;

    public ProductAddedToCartPopUp(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(closePopUp));
    }

    public SearchResultPage clickClosePopUpPage() {
        log.info("close 'product added to cart' pop up");
        closePopUp.click();
        return new SearchResultPage(driver);
    }
}
