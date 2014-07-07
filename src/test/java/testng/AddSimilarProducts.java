package testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddSimilarProductPage;

public class AddSimilarProducts extends BaseTest{

    @DataProvider(name = "products")
    public Object [][] similarProduct(){
        return new Object[][]{
                {"Фен-щетка BEURER HTE 40", "Фен BEURER HDE 30"}
        };
    }

    @Test(dataProvider = "products")
    public void addSimilarProducts(String product1, String product2){

        AddSimilarProductPage addSimilarProductPage = new AddSimilarProductPage(driver);
        addSimilarProductPage.open();
        addSimilarProductPage.addSimilarProduct(product1);
        addSimilarProductPage.addSimilarProduct(product2);
        Assert.assertTrue( addSimilarProductPage.isCompare() );
    }
}
