package pages;

import org.openqa.selenium.WebDriver;

public class BasePages {

    protected String URL = "http://rozetka.com.ua/";
    protected WebDriver driver;

    public BasePages(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(URL);
    }
    public boolean isOpen(){
        return driver.getCurrentUrl().equals(URL);
    }
}
