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

    @FindBy(xpath = "//p[contains(@class, 'cart_navigation')]//a[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckoutPage;

    @FindBy(xpath = "//td[contains(@class, 'cart_delete')]")
    private WebElement deleteItemFromCartButton;  //assume there is only one element in cart. For more elements we will need to use another method

    public CheckOutPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(orderPageBody));
    }

    public Boolean isProductNameCorrect(String expected) {
        return productNameElement.getText().contains(expected);
    }

    public CheckoutAddressPage clickProceedToCheckOutPage() {
        proceedToCheckoutPage.click();
        return new CheckoutAddressPage(driver);
    }

    public CheckOutPage deleteItemFromCart() {
        deleteItemFromCartButton.click();
        return this;
    }
}
