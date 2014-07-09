package similarProducts.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import similarProducts.selenium.WebDriverFactory;
import similarProducts.utils.PropertyLoader;

public class BaseTest {

    public static WebDriver driver;

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
