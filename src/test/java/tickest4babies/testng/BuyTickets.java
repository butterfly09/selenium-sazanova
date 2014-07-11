package tickest4babies.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import tickest4babies.pages.TicketsPage;
import tickest4babies.utils.Log4Test;

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
