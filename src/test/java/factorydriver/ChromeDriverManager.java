package factorydriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.PropertiesManager;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.chrome.driver", propertiesManager.get("driver.chrome"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
    }


}
