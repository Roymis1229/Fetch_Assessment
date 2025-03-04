package org.fetch.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {}

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browser = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                case "headless-chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(options));
                    break;
            }

            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
