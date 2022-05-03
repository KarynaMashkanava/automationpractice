package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage {

    @FindBy(id = "order")
    private WebElement orderPageBody;

    @FindBy(xpath = "//table[@id = 'cart_summary']//p[@class = 'product-name']")
    private WebElement productNameElement;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(orderPageBody));
    }

    public Boolean isProductNameCorrect(String expected) {
        return productNameElement.getText().contains(expected);
    }
}
