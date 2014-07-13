package tests.similarProducts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import selenium.WebDriverFactory;
import selenium.WebDriverWrapper;
import utils.PropertyLoader;

public class BaseTest {
    //public static WebDriverWrapper driver;
    public static WebDriver driver;

    @DataProvider(name = "products")
    public static final Object [][] similarProduct(){
        return new Object[][]{
                {"Фен-щетка BEURER HTE 40", "Фен BEURER HDE 30"}
        };
    }

    @BeforeSuite
    public void initEnviroment(){
        driver = new FirefoxDriver();
        //driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void shutEnviroment(){
        if (driver != null)
            driver.quit();
    }
}
