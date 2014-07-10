package similarProducts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchProductPage extends BasePage{

    private static final By inputField = By.className("header-search-input-text");
    private static final By searchButton = By.className("btn-link-i");
    private static final By productNew = By.className("g-i-list-title");
    private static final By add = By.xpath("//*[@id=\"head_banner_container\"]//a[contains(text(),'Добавить')]");
    //private static final By add = By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div[1]/div/div/div[3]/div/div[1]/div[3]/a");
    private static final By comparing = By.xpath("//a[contains(@href,'comparison')]");
    private static final String findProduct = "//td[%s]//div[@class='item available']//div[@class='title']//a";

    public SearchProductPage(WebDriver driver){
        super(driver);
    }

    public String searchProduct(String product) {
        WebElement element = driver.findElement(inputField);
        element.clear();
        element.sendKeys(product);
        driver.findElement(searchButton).click();
        String findProduct = driver.findElement(productNew).getText();
        return findProduct;
    }

     public void addToComprasion(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(add).click();
    }

    public void openCompressionPage(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(comparing).click();
    }

    public List<String> findProduct(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<String> list = new ArrayList<String>();
        list.add( driver.findElement(By.xpath(String.format(findProduct,2))).getText());
        list.add(driver.findElement(By.xpath(String.format(findProduct,3))).getText());
        return list;
    }
}
