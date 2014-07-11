package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverWrapper;
import utils.Log4Test;

public class TicketsPage extends BasePage {

    private static final By airAndRailwayTickets = By.id("fatmenu_14");
    //private static final By KievVienna = By.xpath("//*[@id=\"fatmenu_14\"]//a[contains(text(),'Киев') AND contains(text(),'Вена')]");
    private static final By KievVienna = By.xpath("//*[@id=\"fatmenu_14\"]/div/div/ol/li[1]/ul/li[9]/a");
    private static final String adultTicket = "//div[@class='adults_block passengers_wrapper']/div[@class='persons']/div[%d]";
    //private static final String childTicket = "//div[@data-field='children']/div[@class='persons']/div[%d]";
    private static final String infantsTicket = "//div[@data-field='infants']/div[@class='persons']/div[%d]";
    private static final By searchButton = By.id("start_search");
    private static final By errorMessage = By.xpath("//div[contains(@class,'error_popup')]//*[contains(text(),'Младенцев не может быть больше, чем взрослых')]");

    public TicketsPage(WebDriverWrapper driver){
       super(driver);
    }

    public void searchTravel(){

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(airAndRailwayTickets));
        builder.perform();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(KievVienna));
        driver.findElement(KievVienna).click();
        Log4Test.info("Направление найдено.");
    }

    public void buyTickets(int adults, int infants){

        driver.findElement(By.xpath(String.format(adultTicket,adults))).click();
        //driver.findElement(By.xpath(String.format(childTicket,children))).click();
        driver.findElement(By.xpath(String.format(infantsTicket,infants))).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
    }

    public boolean isError() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
