package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

public class SearchSimilarProductPage extends BasePage{

    //Log4Test.info

    private static final By inputField = By.className("header-search-input-text");
    private static final By searchButton = By.className("btn-link-i");
    private static final By hairdryer = By.xpath("//*[@id=\"popular_sections\"]//a[contains(text(),'Фены')]");

    public SearchSimilarProductPage(WebDriver driver){
        super(driver);
    }

    public String searchProduct(String product) {

        WebElement element = driver.findElement(inputField);
        element.clear();
        element.sendKeys(product);
        driver.findElement(searchButton).click();
        String typeProduct = driver.findElement(hairdryer).getText();
        return typeProduct;
    }
}
