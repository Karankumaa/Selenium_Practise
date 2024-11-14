package DriverInitialization;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInfo {
    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public WebDriver init_driver() {
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tdriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    }
