package similarProducts.testng;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "products")
    public static final Object [][] similarProduct(){
        return new Object[][]{
                {"Фен-щетка BEURER HTE 40", "Фен BEURER HDE 30"}
        };
    }
}
