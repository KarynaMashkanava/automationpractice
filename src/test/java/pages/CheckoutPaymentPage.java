package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPaymentPage extends BasePage {

    @FindBy(xpath = "//a[@class = 'bankwire']")
    private WebElement bankWirePaymentButton;

    public CheckoutPaymentPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(bankWirePaymentButton));
    }

    public OrderSummaryPage selectBankWireOption() {
        bankWirePaymentButton.click();
        return new OrderSummaryPage(driver);
    }
}
