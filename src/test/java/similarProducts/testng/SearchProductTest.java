package similarProducts.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import similarProducts.pages.SearchProductPage;
import similarProducts.utils.Log4Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchProductTest extends BaseTest{

    @DataProvider(name = "products")
    public Object [][] similarProduct(){
        return new Object[][]{
                {"Фен-щетка BEURER HTE 40", "Фен BEURER HDE 30"}
        };
    }

    @Test(dataProvider = "products")
    public void searchSimilarProducts(String product1, String product2){

        SearchProductPage similarProductPage = new SearchProductPage(driver);
        similarProductPage.open();
        Log4Test.info("Страница открыта.");
        Assert.assertEquals(similarProductPage.searchProduct(product1), product1, Log4Test.info("Первый продукт найден."));
        similarProductPage.addToComprasion();

        Assert.assertEquals( similarProductPage.searchProduct(product2), product2, Log4Test.info("Второй продукт найден."));
        similarProductPage.addToComprasion();
        similarProductPage.openCompressionPage();
        Log4Test.info("Страница с сравнением открыта.");

        Assert.assertEquals( similarProductPage.findFirstProduct(), product1, Log4Test.info("Первый продукт добавлен к сравнению."));
        Assert.assertEquals( similarProductPage.findSecondProduct(), product2, Log4Test.info("Второй продукт добавлен к сравнению."));

        //SearchProductPage searchProductPage = new SearchProductPage(driver);
        //List<String> products = searchProductPage.findProduct();
        //Assert.assertEquals( products.get(0), product1 );
        //Assert.assertEquals( products.get(1), product2 );
    }
}
