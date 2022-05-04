package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
public class OrderSummaryPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'cheque-box')]")
    private WebElement summaryBox;

    @FindBy(xpath = "//button[@type = 'submit' and normalize-space() = 'I confirm my order']")
    private WebElement confirmOrderButton;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(summaryBox));
    }

    public OrderConfirmationPage confirmOrder() {
        log.info("click confirm order");
        confirmOrderButton.click();
        return new OrderConfirmationPage(driver);
    }
}
