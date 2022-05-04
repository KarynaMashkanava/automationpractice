package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
public class CheckoutShippingPage extends BasePage {

    @FindBy(className = "delivery_options_address")
    private WebElement deliveryOptionsAddress;

    @FindBy(name = "processCarrier")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[@id = 'uniform-cgv']/span")
    private WebElement agreeWithTermsCheckbox;

    @FindBy(xpath = "//p[@class = 'fancybox-error']")
    private WebElement agreeWithTermsError;

    public CheckoutShippingPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(deliveryOptionsAddress));
    }

    public CheckoutShippingPage checkAgreeWithTerms() {
        log.info("check agree with terms");
        if (!agreeWithTermsCheckbox.getAttribute("class").equals("checked")) {
            agreeWithTermsCheckbox.click();
        }
        return this;
    }

    public CheckoutPaymentPage clickProceedToCheckoutPage() {
        log.info("click proceed to checkout");
        proceedToCheckoutButton.click();
        return new CheckoutPaymentPage(driver);
    }

    public CheckoutShippingPage clickProceedToCheckoutPageWithError() {
        log.info("click proceed to checkout and expecting to receive error");
        proceedToCheckoutButton.click();
        return new CheckoutShippingPage(driver);
    }

    public String getTermsErrorMessage() {
        return agreeWithTermsError.getText();
    }
}
