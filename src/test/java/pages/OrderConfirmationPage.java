package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
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
        log.info("validating confirmation text");
        return receiptHeader.getText().contains(expected);
    }
}
