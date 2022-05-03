package webdriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeManager extends DriverManager{
    @Override
    public ChromeDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        return new ChromeDriver();
    }
}
