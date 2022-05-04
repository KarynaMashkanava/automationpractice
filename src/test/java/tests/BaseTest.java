package tests;

import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.Constants;
import utilities.MyListener;
import webdriver.DriverFactory;
import webdriver.DriverType;

@Listeners(MyListener.class)
public class BaseTest {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected final User USER = User.builder()
            .email(Constants.VALID_USERNAME)
            .password(Constants.VALID_PASSWORD)
            .build();

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
