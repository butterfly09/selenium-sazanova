package similarProducts.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import similarProducts.pages.SearchProductPage;
import similarProducts.utils.Log4Test;

import java.util.List;

public class SearchProductTest extends BaseTest{

    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;

    @Test(dataProvider = "products")
    public void searchSimilarProducts(String product1, String product2){

        SearchProductPage similarProductPage = new SearchProductPage(driver);
        similarProductPage.open();
        Assert.assertEquals(similarProductPage.searchProduct(product1), product1, Log4Test.info("Первый продукт найден."));
        similarProductPage.addToComprasion();

        Assert.assertEquals( similarProductPage.searchProduct(product2), product2, Log4Test.info("Второй продукт найден."));
        similarProductPage.addToComprasion();
        similarProductPage.openCompressionPage();

        SearchProductPage searchProductPage = new SearchProductPage(driver);
        List<String> products = searchProductPage.findProduct();
        Assert.assertEquals( products.get(FIRST_ELEMENT), product1, Log4Test.info("Первый продукт соответствует добавленому к сравнению.") );
        Assert.assertEquals( products.get(SECOND_ELEMENT), product2, Log4Test.info("Второй продукт соответствует добавленому к сравнению.") );
    }
}
