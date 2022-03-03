package e9;

import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        String x;
        String y;

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert String X : ");
        x = sc.nextLine();
        System.out.println("Insert String Y : ");
        y = sc.nextLine();

        System.out.println("X length : " + x.length());
        System.out.println("y length : " + y.length());
        String XSubString = x.substring(0,3);
        String YSubString = y.substring(y.length() - 3);
        System.out.println("x 3 first chars : " + XSubString);
        System.out.println("y 3 last char : " + YSubString);
        System.out.println(" x 6th char : " + x.charAt(5));
        String SumString = x.substring(0,2) + YSubString;
        System.out.println("x 3 first + y 3 last : " + SumString);
        if(x.equals(y))
        {
            System.out.println("2 strings are equal case-sensitively");
        }
        else
        {
            System.out.println("2 strings are unequal case-sensitively");
        }

        if(x.equalsIgnoreCase(y))
        {
            System.out.println("2 strings are equal case-insensitively");
        }
        else
        {
            System.out.println("2 strings are unequal case-insensitively");
        }
        int indx = x.indexOf(y);
        if(indx == -1)
        {
            System.out.println("there's no y in x");
        }
        else
        {
            System.out.println("There's y in x at " + indx);
        }

        int numSubStr = 0;
        int flag = 0;
        flag = x.indexOf(y,flag);
        if(flag != -1)
        {
            numSubStr++;
        }
        while (flag != -1)
        {
            flag = x.indexOf(y,flag+1);
            if(flag != -1)
            {
                numSubStr++;
            }
        }
        if(numSubStr == 0)
        {
            System.out.println("There's no y in x");
        }
        if(numSubStr == 1){
            System.out.println("There is a y in x");
        }
        else
        {
            System.out.println("There are " +numSubStr + " ys in x" );
        }
    }
}
