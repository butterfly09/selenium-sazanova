package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TicketsPage extends BasePage{

    private static final By airAndRailwayTickets = By.id("fatmenu_14");
    private static final By KievVienna = By.xpath("//*[@id=\"fatmenu_14\"]//a[contains(text(),'Киев-Вена')]");
    private static final String adultTicket = "//div[@class='adults_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String childTicket = "//div[@data-field='children']/div[@class='persons']/div[%d]";
    private static final String infantsTicket = "//div[@data-field='infants']/div[@class='persons']/div[%d]";
    private static final By searchButton = By.id("start_search");
    private static final By errorMessage = By.className("popup error_popup");

    public TicketsPage(WebDriver driver){
       super(driver);
       URL = "http://rozetka.com.ua/travel/IEV/VIE/";
    }

    public void searchTravel(){

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(airAndRailwayTickets));
        builder.perform();

        driver.findElement(KievVienna).click();
    }

    public void buyTickets(int adults, int children, int infants){

        driver.findElement(By.xpath(String.format(adultTicket,adults))).click();
        driver.findElement(By.xpath(String.format(childTicket,children))).click();
        driver.findElement(By.xpath(String.format(infantsTicket,infants))).click();
        driver.findElement(searchButton);
    }

    public boolean isError() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
