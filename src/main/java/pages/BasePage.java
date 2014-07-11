package pages;

import org.openqa.selenium.WebDriver;
import utils.Log4Test;

public class BasePage {

    protected String URL = "http://rozetka.com.ua/";
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(URL);
        Log4Test.info("Страница открыта.");
    }

    public boolean isOpen(){
        return driver.getCurrentUrl().equals(URL);
    }
}
