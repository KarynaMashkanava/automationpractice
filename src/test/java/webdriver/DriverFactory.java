package webdriver;

public class DriverFactory {
    public DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxManager();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return driverManager;
    }
}
