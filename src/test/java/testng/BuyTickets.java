package testng;

import junit.framework.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;

public class BuyTickets extends BaseTest{

    @Test
    public void buy2infantTicket(){
        TicketsPage page = new TicketsPage(driver);
        page.buyTicket(1,1,2);
        Assert.assertTrue(page.isErorr());
    }
}
