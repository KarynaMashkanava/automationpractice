package tests;

import factorydriver.DriverFactory;
import factorydriver.DriverManager;
import factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
