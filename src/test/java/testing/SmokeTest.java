package testing;

import org.testng.annotations.Test;

public class SmokeTest {



    @Test
    public void sTest(){
        int a = 0;
        int b = 20000;
        do {
            a = a + b;
        } while (a > -32768 || a  <32767);
         System.out.println("Current number: " + a);
         System.out.println("Overload:" + (32767 - Math.abs(a)));
        /*for(int i = 0; i < 32768; i++)
        {
            a = a + i;
            if (a < -32768 && a > 32767)
            {
                System.out.println("Current number: " + a);
                System.out.println("Overload:" + (32767 - Math.abs(a)));
            }
        } */

    }
}
