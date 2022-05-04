package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
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
        log.info("click proceed to check out");
        proceedToCheckoutAddress.click();
        return new CheckoutShippingPage(driver);
    }
}
