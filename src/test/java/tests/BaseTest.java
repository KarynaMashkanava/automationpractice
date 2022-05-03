package tests;

import org.testng.annotations.*;
import utilities.Constants;
import utilities.MyListener;
import webdriver.DriverFactory;
import webdriver.DriverType;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@Listeners(MyListener.class)
public class BaseTest {
    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("CHROME") DriverType browser) {
        driver = new DriverFactory().getDriverManager(browser).createWebDriver();
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
