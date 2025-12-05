package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import util.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initDriver() {

        String browser = ConfigReader.get("browser");
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser NOT supported: " + browser);
        }

        driver.manage().window().maximize();
        tlDriver.set(driver);

        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void removeDriver() {
        getDriver().quit();
        tlDriver.remove();
    }
}
