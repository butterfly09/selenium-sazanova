package test.tickets4babies;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.similarProducts.BaseTest;
import pages.TicketsPage;
import utils.Log4Test;

public class BuyTickets extends BaseTest {

    @Test
    public void buy2infantsTickets(){
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.open();
        ticketsPage.searchTravel();
        ticketsPage.buyTickets(1,2);
        Assert.assertTrue(ticketsPage.isError(), Log4Test.error("Младенцев не может быть больше, чем взрослых."));
    }
}
