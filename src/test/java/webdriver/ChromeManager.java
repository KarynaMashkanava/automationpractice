package webdriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeManager extends DriverManager{
    @Override
    public ChromeDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("disable-gpu");
        return new ChromeDriver(chromeOptions);
    }
}
