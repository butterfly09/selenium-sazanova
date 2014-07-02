package testng;

import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringLength {

    @DataProvider
    public Object[][] parseString(){
        return new Object[][]{{"tensymbols", 10},
                {"svsazanova", 10},
                {"s.sazanova", 10}};
    }

    @Test(dataProvider = "parseString")
    public void stringLength(String actual, int expected){
        int result = actual.length();
        Assert.assertEquals(result, expected);
    }
}
