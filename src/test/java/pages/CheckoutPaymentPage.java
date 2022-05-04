package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
public class CheckoutPaymentPage extends BasePage {

    @FindBy(xpath = "//a[@class = 'bankwire']")
    private WebElement bankWirePaymentButton;

    public CheckoutPaymentPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(bankWirePaymentButton));
    }

    public OrderSummaryPage selectBankWireOption() {
        log.info("select bank wire option");
        bankWirePaymentButton.click();
        return new OrderSummaryPage(driver);
    }
}
