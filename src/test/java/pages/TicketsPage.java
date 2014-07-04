package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsPage extends BasePages{

    private static final String adultTicket = "//div[@class='adults_block passengers_wraper']/div[@class='persons']/div[%d]";
    private static final String childrenTicket = "//div[@data-field='children passengers_wraper']/div[@class='persons']/div[%d]";
    private static final String infantTicket = "//div[@class='adults_block passengers_wraper']/div[@class='performs']/div[%d]";
    private static final By findBtn = By.id("start_search");
    private static final By errorPour = By.className("error_pour");

    public TicketsPage(WebDriver driver){
        super(driver);
        URL = "http://rozetka.com.ua/travel/IEV/MOW";
    }

    public void buyTicket(int adults, int children, int infants){
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(adultTicket,adults))));
        driver.findElement(By.xpath(String.format(adultTicket,adults))).click();
        driver.findElement(By.xpath(String.format(childrenTicket,children))).click();
        driver.findElement(By.xpath(String.format(infantTicket,infants))).click();
        driver.findElement(findBtn);
    }

    public boolean isErorr(){
        return driver.findElement(errorPour).size() > 0;
    }
}
