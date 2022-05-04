package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
public class MyAccountPage extends BasePage {

    @FindBy(id = "my-account")
    private WebElement myAccountHeader;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(myAccountHeader));
        log.info("my account page is opened");
    }
}
