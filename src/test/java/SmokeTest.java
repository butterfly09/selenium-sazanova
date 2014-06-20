import junit.framework.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SmokeTest {

    //@Parameters({"5","1","10","3"})
    @Test
    public void smokeTest(){

        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(5);
        array.add(1);
        array.add(10);
        array.add(3);

        for(int i = 0; i < array.size(); i++)
        {
            for(int j = i+1; j < array.size(); j++)
            {
                if ( array.get(i) > array.get(j)  ) {
                    int tmp = array.get(i);
                    array.set( i, array.get(j) );
                    array.set( j, tmp );
                }
            }
        }

        for(int i = 0; i < array.size(); i++)
        {
            System.out.println(array.get(i));
        }

        ArrayList<Integer> array1 = new ArrayList<Integer>();
        array1.add(1);
        array1.add(3);
        array1.add(5);
        array1.add(10);

        Assert.assertEquals(array, array1);
    }
}
