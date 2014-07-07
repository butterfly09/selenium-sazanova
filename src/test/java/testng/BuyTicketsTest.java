package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;
import utils.Log4Test;

public class BuyTicketsTest extends BaseTest{

    @Test
    public void buy2infantsTickets(){
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.open();
        ticketsPage.searchTravel();
        ticketsPage.buyTickets(1,2);
        Assert.assertTrue(ticketsPage.isError(), Log4Test.error("You cann't order tickets for 2 babies and adult"));
    }
}
