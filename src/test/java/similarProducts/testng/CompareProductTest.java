package similarProducts.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import similarProducts.pages.CompareProductsPage;
import similarProducts.utils.Log4Test;

import java.util.List;
import java.util.Map;

public class CompareProductTest extends BaseTest{

    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;

    @Test(dataProvider = "products")
    public void compare2products(String product1, String product2){
        CompareProductsPage compareProductsPage = new CompareProductsPage(driver);
        compareProductsPage.open();

        compareProductsPage.searchProduct(product1);
        compareProductsPage.addToComprasion();

        compareProductsPage.searchProduct(product2);
        compareProductsPage.addToComprasion();

        compareProductsPage.openCompressionPage();

        List<Map<String,String>> list1 = compareProductsPage.compare();
        Map<String,String> differences1 = list1.get(FIRST_ELEMENT);
        Map<String,String> differences2 = list1.get(SECOND_ELEMENT);
        List<Map<String,String>> list2 = compareProductsPage.compareForSite();
        Map<String,String> differences11 = list2.get(FIRST_ELEMENT);
        Map<String,String> differences22 = list2.get(SECOND_ELEMENT);
        Assert.assertTrue(differences1.equals(differences11), Log4Test.info("Отличия первого продукта совпадают."));
        Assert.assertTrue(differences2.equals(differences22), Log4Test.info("Отличия второго продукта совпадают."));
    }
}
