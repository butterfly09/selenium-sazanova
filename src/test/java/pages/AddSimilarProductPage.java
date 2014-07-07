package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSimilarProductPage extends SearchSimilarProductPage {

    private static final By compare = By.xpath("//*[@id=\"head_banner_container\"]//a[contains(text(),'Добавить')]");

    public AddSimilarProductPage(WebDriver driver){
        super(driver);
    }

    public void addSimilarProduct(String product){

        searchProduct(product);
        driver.findElement(compare).click();
    }

    public boolean isCompare(){
        driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div[1]/div/div/div[3]/div/div[1]/div[3]/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("body-layout")));
        return driver.findElement(By.className("body-layout")).isDisplayed();
    }
}
