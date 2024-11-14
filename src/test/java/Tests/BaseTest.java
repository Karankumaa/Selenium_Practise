package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import DriverInitialization.DriverInfo;
import Pages.HomePage;

public class BaseTest {
	protected  DriverInfo driverInfo;
    protected  WebDriver driver;
    protected  HomePage home;

    @BeforeTest
    public void baseSetUp() {
        driverInfo = new DriverInfo();
        driver = driverInfo.init_driver();
        home = new HomePage(driver);
        driver.get("https://formy-project.herokuapp.com/");
        home = new HomePage(driver);
        System.out.println("[BaseTest] Driver initialized and navigated to HomePage.");
    }

    @AfterTest
    public void baseTearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("[BaseTest] Driver quit successfully.");
        }
    }
}
