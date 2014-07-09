package similarProducts.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import similarProducts.utils.Log4Test;
import similarProducts.utils.PropertyLoader;

import java.io.File;

public class WebDriverFactory {

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static WebDriver initDriver(String broserName)
    {
        WebDriver driver = null;
        if (broserName.equals(FIREFOX))
        {
            driver = new FirefoxDriver();
        } else
        if (broserName.equals(CHROME))
        {
            File file = new File(PropertyLoader.loadProperty("selenium.chrome.driver.path"));
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            driver = new ChromeDriver();
        } else
            System.out.println(broserName);
            Assert.fail(Log4Test.error("WebDriver not defined"));
        return driver;
    }
}
