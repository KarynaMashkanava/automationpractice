package webdriver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    public abstract WebDriver createWebDriver();

    public WebDriver getDriver() {
        return driver;
    }
}
