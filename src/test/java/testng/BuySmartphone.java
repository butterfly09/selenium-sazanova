package testng;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BuySmartphone {

    public void buySmartphone(){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://rozetka.com.ua/");
        String result1 = driver.findElement(By.className("m-cart-empty")).getText();
        Assert.assertEquals(result1, "Корзина пуста");

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("phones-mp3-gps")));
        builder.perform();

        driver.findElement(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[4]/div/div/div[1]/div/div/div[4]/div/div/div[1]/div[2]/a/span")).click();
        driver.findElement(By.id("sort_view")).click();
        driver.findElement(By.xpath("//*[@id=\"sort_view\"]/div/div/ul/li[1]/a")).click();
        driver.findElement(By.name("topurchasesfromcatalog")).click();
        String result2 = driver.findElement(By.xpath("//*[@id=\"cart-popup\"]/div/div/div[1]/div[2]/div/div[3]/div[1]/a")).getText();
        Assert.assertEquals(result2, "Fly IQ239 White");

        driver.quit();
    }
}
