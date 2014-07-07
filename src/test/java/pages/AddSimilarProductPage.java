package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSimilarProductPage extends SearchSimilarProductPage {

    private static final By add = By.xpath("//*[@id=\"head_banner_container\"]//a[contains(text(),'Добавить')]");
    private static final By compare = By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div[1]/div/div/div[3]/div/div[1]/div[3]/a");
    //private static final By compare = By.xpath("//a[contains(@href,'comparison')]");
    //private static final By compare = By.xpath("//*[@id=\"head_banner_container\"]//a[contains(text(),'к сравнению')]");
    //private static final By compare = By.xpath("//div[@class='g-i-list-compare']//a[contains(text(),'к сравнению')]");
    private static final By compering = By.className("body-layout");



    public AddSimilarProductPage(WebDriver driver){
        super(driver);
    }

    public void addSimilarProduct(String product){

        searchProduct(product);
        driver.findElement(add).click();
    }

    public boolean isCompare(){
        driver.findElement(compare).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(compering));
        return driver.findElement(compering).isDisplayed();
    }
}
