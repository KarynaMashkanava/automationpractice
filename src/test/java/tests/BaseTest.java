package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.Constants;
import utilities.MyListener;
import webdriver.DriverFactory;
import webdriver.DriverType;

@Listeners(MyListener.class)
public class BaseTest {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("CHROME") DriverType browser) {
        driver.set(new DriverFactory().getDriverManager(browser).createWebDriver());
        driver.get().manage().window().maximize();
        driver.get().get(Constants.URL);
    }

    @AfterMethod()
    public void tearDown() {
        driver.get().quit();
    }
}
