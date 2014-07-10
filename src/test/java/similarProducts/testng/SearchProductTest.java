package similarProducts.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import similarProducts.pages.SearchProductPage;
import similarProducts.utils.Log4Test;

import java.util.List;

public class SearchProductTest extends BaseTest{

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

        SearchProductPage searchProductPage = new SearchProductPage(driver);
        List<String> products = searchProductPage.findProduct();
        Assert.assertEquals( products.get(0), product1, Log4Test.info("Первый продукт добавлен к сравнению.") );
        Assert.assertEquals( products.get(1), product2, Log4Test.info("Второй продукт добавлен к сравнению.") );
    }
}
