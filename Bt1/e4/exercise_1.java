package e4;

import java.util.Scanner;

public class exercise_1 {
    public static void main(String args[])
    {
        int n;
        boolean isNumericAndPositive;
        String inputString;
        int Sum = 0;

        do {
            System.out.println("Enter a number :");
            Scanner input = new Scanner(System.in);
            inputString = input.next();
            try {
                n = Integer.parseInt((inputString));
                if(n < 0)
                {
                    isNumericAndPositive = false;
                    System.out.println("Please enter positive number :");
                    continue;
                }
                isNumericAndPositive = true;
                for(int i = 1; i <= n; i++){
                    Sum += i;
                }
            }
            catch(NumberFormatException e){
               System.out.println("Please enter a number");
               isNumericAndPositive = false;

            }
        }
        while(!isNumericAndPositive);

        System.out.println("Sum is : " + Sum);


    }
}
