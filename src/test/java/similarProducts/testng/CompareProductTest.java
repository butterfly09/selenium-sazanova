package similarProducts.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import similarProducts.pages.CompareProductsPage;
import similarProducts.utils.Log4Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CompareProductTest extends BaseTest{

    @DataProvider(name = "products")
    public Object [][] similarProduct(){
        return new Object[][]{
                {"Фен-щетка BEURER HTE 40", "Фен BEURER HDE 30"}
        };
    }

    @Test(dataProvider = "products")
    public void compare2products(String product1, String product2){
        CompareProductsPage compareProductsPage = new CompareProductsPage(driver);
        compareProductsPage.open();
        Log4Test.info("Страница открыта.");

        compareProductsPage.searchProduct(product1);
        Log4Test.info("Первый продукт найден.");
        compareProductsPage.addToComprasion();
        Log4Test.info("Первый продукт добавлен к сравнению");

        compareProductsPage.searchProduct(product2);
        Log4Test.info("Второй продукт найден.");
        compareProductsPage.addToComprasion();
        Log4Test.info("Второй продукт добавлен к сравнению");

        compareProductsPage.openCompressionPage();
        Log4Test.info("Страница сравнения открыта");

        List<Map<String,String>> list = compareProductsPage.compare();
        Map<String,String> differences1 = list.get(0);
        Map<String,String> differences2 = list.get(1);
        Map<String,String> differences11 = list.get(2);
        Map<String,String> differences22 = list.get(3);
        Assert.assertTrue(differences1.equals(differences11));
        Assert.assertTrue(differences2.equals(differences22));
    }
}
