package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderConfirmationPage extends BasePage {

    @FindBy(xpath = "//h1[normalize-space() = 'Order confirmation']")
    private WebElement confirmationHeader;

    @FindBy(xpath = "//p[@class = 'cheque-indent']")
    private WebElement receiptHeader;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(confirmationHeader));
    }

    public Boolean validateConfirmationContainsExpectedText(String expected) {
        return receiptHeader.getText().contains(expected);
    }
}
