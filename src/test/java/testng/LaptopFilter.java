package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LaptopFilter {

    public static WebDriver driver;
    public static final By notebookLink = By.xpath("//a[contains(@*,'notebooks/c80004/')]");

    @DataProvider
    public Object[][] filter(){
        return new Object[][]{{"tensymbols"},
                {"svsazanova"}};
    }

    @BeforeSuite
    public void initEnv(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://rozetka.com.ua/");
    }

    @Test(dataProvider = "filter")
    public void laptopFilter(){

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("computers-notebooks")));
        builder.perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("notebookLink")));
        driver.findElement(By.xpath("//a[contains(@*,'http://rozetka.com.ua/notebooks/c80004/')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'notebooks)]")));
        driver.findElement(By.xpath("//a[contains(@href, 'notebooks)]")).click();

        /*Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("computers-notebooks")));
        builder.perform();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"computers-notebooks\"]/div/div/ol/li[1]/ul[1]/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"computers-notebooks\"]/div/div/ol/li[1]/ul[1]/li[1]/a")).click();

        driver.quit();  */
    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null)
            driver.quit();
    }
}
