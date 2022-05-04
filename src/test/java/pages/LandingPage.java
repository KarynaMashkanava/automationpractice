package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
public class LandingPage extends BasePage {

    @FindBy(id = "index")
    private WebElement indexBodyElement;

    public LandingPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(indexBodyElement));
        log.info("landing page opened!");
    }
}
