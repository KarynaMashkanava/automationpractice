package webdriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager extends DriverManager{

    @Override
    public FirefoxDriver createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/java/recources/geckodriver");
        return new FirefoxDriver();
    }
}
