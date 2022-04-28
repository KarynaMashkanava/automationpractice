package utilities;

import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class MyListener implements ITestListener {


    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        byte[] sourceFile = saveScreenshot(result);
        Files.write(Paths.get("target/screenshot_" + new Random().nextInt() + ".png"), sourceFile);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(ITestResult result) {
        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        return screenShot.getScreenshotAs(OutputType.BYTES);
    }
}
