package testng;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BuySmartphone {
/*
    @Test
    public void buySmartphone(){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://rozetka.com.ua/");
        driver.manage().window().maximize();
        String result1 = driver.findElement(By.className("m-cart-empty")).getText();
        Assert.assertEquals(result1, "Корзина пуста");

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("phones-mp3-gps")));
        builder.perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"head_banner_container\"]/div[4]/div/div/div[1]/div/div/div[4]/div/div/div[1]/div[2]/a/span")));
        driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[4]/div/div/div[1]/div/div/div[4]/div/div/div[1]/div[2]/a/span")).click();

        driver.findElement(By.xpath("//*[@id=\"sort_view\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"sort_view\"]/div/div/ul/li[1]/a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("topurchasesfromcatalog")));
        driver.findElement(By.name("topurchasesfromcatalog")).click();
        String result2 = driver.findElement(By.className("cell detail")).getText();
        Assert.assertEquals(result2, "Товар");

        driver.quit();
    }*/
}

