package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAddedToCartPopUp extends BasePage {

    @FindBy(className = "cross")
    private WebElement closePopUp;

    public ProductAddedToCartPopUp(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(closePopUp));
    }

    public SearchResultPage clickClosePopUpPage() {
        closePopUp.click();
        return new SearchResultPage(driver);
    }
}
