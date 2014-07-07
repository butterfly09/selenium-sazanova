package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparingSimilarProductPage extends AddSimilarProductPage{

    private static final By compare = By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div[1]/div/div/div[3]/div/div[1]/div[3]/a");

    public ComparingSimilarProductPage(WebDriver driver){
        super(driver);
    }

    public void comparingProduct(String product){

        searchProduct(product);
        addSimilarProduct(product);
        driver.findElement(compare).click();
    }
}
