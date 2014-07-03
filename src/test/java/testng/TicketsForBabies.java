package testng;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TicketsForBabies {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeSuite
    public void initEnviroment(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://rozetka.com.ua/");

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void ticketsForBabies(){

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("fatmenu_14")));
        builder.perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"fatmenu_14\"]/div/div/ol/li[1]/ul/li[9]/a")));
        driver.findElement(By.xpath("//*[@id=\"fatmenu_14\"]/div/div/ol/li[1]/ul/li[9]/a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.className("persons")));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/div[4]/div[2]/div[2]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("start_search")));
        driver.findElement(By.id("start_search")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"head_banner_container\"]/div[5]/div/div/p")));
        String result = driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[5]/div/div/p")).getText();
        Assert.assertEquals(result, "Младенцев не может быть больше, чем взрослых(младенцев - 2, взрослых - 1)");
    }

    @AfterSuite
    public void shutEnviroment(){
        if (driver != null)
            driver.quit();
    }
}
