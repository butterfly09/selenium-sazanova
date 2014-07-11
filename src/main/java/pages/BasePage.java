package pages;

import org.openqa.selenium.WebDriver;
import selenium.WebDriverWrapper;
import utils.Log4Test;

public class BasePage {

    protected String URL = "http://rozetka.com.ua/";
    protected WebDriverWrapper driver;

    public BasePage(WebDriverWrapper driver){
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
