package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

    @FindBy(id = "index")
    private WebElement indexBodyElement;

    public LandingPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(indexBodyElement));
    }
}
