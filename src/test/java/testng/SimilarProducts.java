package testng;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimilarProducts {

    public static WebDriver driver;
    public static WebDriverWait wait;

    private static final By inputField = By.className("header-search-input-text");
    private static final By searchButton = By.className("btn-link-i");
    private static final By compare = By.xpath("//*[@id=\"head_banner_container\"]//a[contains(text(),'Добавить')]");
    private static final By product = By.xpath("//*[@id=\"popular_sections\"]//a[contains(text(),'Фены')]");

    @DataProvider
    public Object[][] searchElements(){
        return new Object[][]{{"Фен-щетка BEURER HTE 40"}};
                //{"Фен BEURER HDE 30"}};
                //{"Фен"}};
    }

    @BeforeSuite
    public void initEnviroment(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://rozetka.com.ua/");

        wait = new WebDriverWait(driver, 10);
    }

    @Test(dataProvider = "searchElements")
    public void searchSimilarProducts(String searchElement1){

        WebElement element = driver.findElement(inputField);
        element.sendKeys(searchElement1);
        driver.findElement(searchButton).click();
        String product1 = driver.findElement(product).getText();
        driver.findElement(compare).click();

        element = driver.findElement(inputField);
        element.clear();
        element.sendKeys("Фен BEURER HDE 30");
        driver.findElement(searchButton).click();
        String product2 = driver.findElement(product).getText();
        driver.findElement(compare).click();

        Assert.assertEquals(product1, product2);
        //driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div[1]/div/div/div[3]/div/div[1]/div[3]/a")).click();

/*
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("bt")));
        builder.perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bt\"]/div/div/ol/li[3]/ol/li[2]/ul/li[15]/a")));
        driver.findElement(By.xpath("//*[@id=\"bt\"]/div/div/ol/li[3]/ol/li[2]/ul/li[15]/a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sort_producer\"]/li[2]/label/input")));
        driver.findElement(By.xpath("//*[@id=\"sort_producer\"]/li[2]/label/input")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/a")));
        driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/a")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"block_with_goods\"]/div/div[1]/div[1]/div[1]/div/div/div[4]/div[1]/label/input")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"block_with_goods\"]/div/div[1]/div[2]/div[1]/div/div/div[4]/div[1]/span/a")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"compare-menu\"]/ul/li[2]/a")).click();

        String result1 = driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
        Assert.assertEquals(result1, "фен-щетка");
        String result2 = driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div/div[2]/table/tbody/tr[1]/td[3]")).getText();
        Assert.assertEquals(result2, "обычный");
*/
    }

    @AfterSuite
    public void closeEnviroment(){
        if (driver != null)
        driver.quit();
    }
}
