package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutAddressPage extends BasePage {

    @FindBy(id = "uniform-id_address_delivery")
    private WebElement deliveryAddress;

    @FindBy(name = "processAddress")
    private WebElement proceedToCheckoutAddress;

    public CheckoutAddressPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(deliveryAddress));
    }

    public CheckoutShippingPage proceedToCheckout() {
        proceedToCheckoutAddress.click();
        return new CheckoutShippingPage(driver);
    }
}
