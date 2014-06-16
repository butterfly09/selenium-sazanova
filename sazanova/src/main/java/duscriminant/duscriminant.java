package duscriminant;


import java.util.ArrayList;

public class duscriminant {

    public static void main(String[] args)
    {
        double a = 1;
        double b = -5;
        double c = 6;
        if (korni(a, b, c) == null)
        {
            System.out.println("Дискриминант меньше 0, пожалуйста, введите другие коэффициенты.");
        }
        else System.out.println(korni(a, b, c));
    }

    public static ArrayList<Double> korni(double a, double b, double c){
        ArrayList<Double> korni = new ArrayList<Double>();
        double D = b*b - 4*a*c;
        if (D < 0)
        { return null;}

        if (D == 0)
        {
            double x = -b/(2*a);
            korni.add(x);
        }

        if (D > 0)
        {
            double x1 = (-b + Math.sqrt(D))/(2*a);
            korni.add(x1);
            double x2 = (-b - Math.sqrt(D))/(2*a);
            korni.add(x2);
        }

        return korni;
    }
}
