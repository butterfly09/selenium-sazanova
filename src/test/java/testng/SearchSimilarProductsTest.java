package testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchSimilarProductPage;

public class SearchSimilarProductsTest extends BaseTest{

    @DataProvider(name = "products")
    public Object [][] similarProduct(){
        return new Object[][]{
                {"Фен-щетка BEURER HTE 40", "Фен BEURER HDE 30"}
        };
    }

    @Test(dataProvider = "products")
    public void searchSimilarProducts(String product1, String product2){

        SearchSimilarProductPage similarProductPage = new SearchSimilarProductPage(driver);
        similarProductPage.open();
        Assert.assertEquals( similarProductPage.searchProduct(product1), similarProductPage.searchProduct(product2) );
    }
}
