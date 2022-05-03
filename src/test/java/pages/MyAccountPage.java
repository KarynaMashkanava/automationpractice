package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

    @FindBy(id = "my-account")
    private WebElement myAccountHeader;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(myAccountHeader));
    }
}
