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

    private static final By airAndRailwayTickets = By.id("fatmenu_14");
    private static final By KievVienna = By.xpath("//*[@id=\"fatmenu_14\"]//a[contains(text(),'Киев-Вена')]");
    private static final By twoBabies = By.xpath("//*[@id=\"content\"]//div[contains(@class,'infants')]/div/div[2]");
    private static final By search = By.id("start_search");
    private static final By message = By.xpath("//div[contains(@class,'error_popup')]//*[contains(text(),'Младенцев не может быть больше, чем взрослых')]");

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
        builder.moveToElement(driver.findElement(airAndRailwayTickets));
        builder.perform();

        wait.until(ExpectedConditions.elementToBeClickable(KievVienna));
        driver.findElement(KievVienna).click();

        wait.until(ExpectedConditions.elementToBeClickable(twoBabies));
        driver.findElement(twoBabies).click();

        wait.until(ExpectedConditions.elementToBeClickable(search));
        driver.findElement(search).click();

        wait.until(ExpectedConditions.elementToBeClickable(message));
        String result = driver.findElement(message).getText();
        Assert.assertEquals(result, "Младенцев не может быть больше, чем взрослых(младенцев - 2, взрослых - 1)");
    }

    @AfterSuite
    public void shutEnviroment(){
        if (driver != null)
            driver.quit();
    }
}
