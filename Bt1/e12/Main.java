package e12;

import java.util.Scanner;

public class Main {
    /**
     * Print pascal triangle with the heigh of n
     * @param n height of pascal triangle
     */
    public static void printPascal(int n)
    {
        int [][] pascalArray = new int[n][n];

        for(int line = 0; line < n; line++)
        {
            for(int i = 0 ; i <= line ; i ++)
            {
                if(i == 0 || i == line)
                {
                    pascalArray[line][i] = 1;
                }
                else
                {
                    pascalArray[line][i] = pascalArray[line-1][i] + pascalArray[line-1][i-1];
                }
                System.out.print(pascalArray[line][i] + " ");
            }
            System.out.print("\n");
        }
    }
    /**
     * Hàm main để chạy chương trình
     */

    public static void main(String args[])
    {
        // Nhập n
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert n : ");
        n = sc.nextInt();
        printPascal(n);
    }
}
