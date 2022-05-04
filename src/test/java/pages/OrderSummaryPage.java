package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        confirmOrderButton.click();
        return new OrderConfirmationPage(driver);
    }
}
