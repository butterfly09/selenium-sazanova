package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;

public class BuyTickets extends BaseTest{

    @Test
    public void buy2infantsTickets(){
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.open();
        ticketsPage.searchTravel();
        ticketsPage.buyTickets(1,2);
        Assert.assertTrue(ticketsPage.isError());
    }
}
