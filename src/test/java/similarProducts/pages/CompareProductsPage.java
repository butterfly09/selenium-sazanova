package similarProducts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CompareProductsPage extends SearchProductPage{

    private static final By table = By.tagName("tbody");
    private static final By tr = By.tagName("tr");
    private static final By td = By.tagName("td");
    private static final By differences = By.className("xhr");

    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int THIRD_ELEMENT = 2;

    public CompareProductsPage(WebDriver driver){
        super(driver);
    }

    public List<Map<String,String>> compare() {
        List<Map<String, String>> list1 = new ArrayList();
        Map<String, String> differences1 = new TreeMap();
        Map<String, String> differences2 = new TreeMap();
        list1.add(differences1);
        list1.add(differences2);
        Map<String, String> product1Properties = new TreeMap();
        Map<String, String> product2Properties = new TreeMap();
        WebElement table_element = driver.findElement(table);
        List<WebElement> tr_collection = table_element.findElements(tr);

        for (WebElement trElement : tr_collection) {
            List<WebElement> td_collection = trElement.findElements(td);
            product1Properties.put(td_collection.get(FIRST_ELEMENT).getText(), td_collection.get(SECOND_ELEMENT).getText());
            product2Properties.put(td_collection.get(FIRST_ELEMENT).getText(), td_collection.get(THIRD_ELEMENT).getText());
        }

        for (Map.Entry<String, String> entry : product1Properties.entrySet()) {
            if (!entry.getValue().equals(product2Properties.get(entry.getKey()))) {
                differences1.put(entry.getKey(), entry.getValue());
                differences2.put(entry.getKey(), product2Properties.get(entry.getKey()));
            }
        }
        return list1;
    }

    public List<Map<String,String>> compareForSite(){
        driver.findElement(differences).click();
        List<Map<String, String>> list2 = new ArrayList();
        Map<String,String> product1PropertiesForSite = new TreeMap();
        Map<String,String> product2PropertiesForSite = new TreeMap();
        WebElement table_element2 = driver.findElement(table);
        List<WebElement> tr_collection2=table_element2.findElements(tr);

        for(WebElement trElement : tr_collection2)
        {
            List<WebElement> td_collection2=trElement.findElements(td);
            if (!td_collection2.get(FIRST_ELEMENT).getText().equals("")) {
                product1PropertiesForSite.put(td_collection2.get(FIRST_ELEMENT).getText(),td_collection2.get(SECOND_ELEMENT).getText());
                product2PropertiesForSite.put(td_collection2.get(FIRST_ELEMENT).getText(),td_collection2.get(THIRD_ELEMENT).getText());
            }
        }
        list2.add(product1PropertiesForSite);
        list2.add(product2PropertiesForSite);
        return list2;
    }
}
