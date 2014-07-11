package test.tickets4babies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import selenium.WebDriverFactory;
import selenium.WebDriverWrapper;
import utils.PropertyLoader;

public class BaseTest {

    public static WebDriverWrapper driver;

    @BeforeSuite
    public void initEnviroment(){
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void shutEnviroment(){
        if (driver != null)
            driver.quit();
    }
}
