package similarProducts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CompareProductsPage extends SearchProductPage{

    public CompareProductsPage(WebDriver driver){
        super(driver);
    }

    public List<Map<String,String>> compare(){
        List<Map<String,String>> list = new ArrayList();
        Map<String,String> differences1 = new TreeMap();
        Map<String,String> differences2 = new TreeMap();
        list.add(differences1);
        list.add(differences2);
        Map<String,String> product1Properties = new TreeMap();
        Map<String,String> product2Properties = new TreeMap();
        WebElement table_element = driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div/div[2]/table/tbody"));
        List<WebElement> tr_collection=table_element.findElements(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div/div[2]/table/tbody/tr"));

        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            product1Properties.put(td_collection.get(0).getText(),td_collection.get(1).getText());
            product2Properties.put(td_collection.get(0).getText(),td_collection.get(2).getText());
        }

        for (Map.Entry<String, String> entry : product1Properties.entrySet()) {
             if (!entry.getValue().equals(product2Properties.get(entry.getKey())))
            {
                differences1.put(entry.getKey(),entry.getValue());
                differences2.put(entry.getKey(),product2Properties.get(entry.getKey()));
            }
        }

        driver.findElement(By.xpath("//*[@id=\"compare-menu\"]/ul/li[2]/a")).click();
        Map<String,String> product1PropertiesForSite = new TreeMap();
        Map<String,String> product2PropertiesForSite = new TreeMap();
        WebElement table_element2 = driver.findElement(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div/div[2]/table/tbody"));
        List<WebElement> tr_collection2=table_element2.findElements(By.xpath("//*[@id=\"head_banner_container\"]/div[3]/div/div/div[2]/table/tbody/tr"));

        for(WebElement trElement : tr_collection2)
        {
            List<WebElement> td_collection2=trElement.findElements(By.xpath("td"));
            product1PropertiesForSite.put(td_collection2.get(0).getText(),td_collection2.get(1).getText());
            product2PropertiesForSite.put(td_collection2.get(0).getText(),td_collection2.get(2).getText());
        }
        list.add(product1PropertiesForSite);
        list.add(product2PropertiesForSite);
        return list;
    }

}
