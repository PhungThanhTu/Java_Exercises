package e4;

import java.util.Scanner;

public class Main {
    /**
     * Viết chương trình tính tổng của dãy số sau: S(n) = 1 + 2 + 3 +...+ n
     * (n: nhập từ bàn phím, kiểm tra điều kiện đầu vào n nguyên không âm
     */
    public static void main(String args[])
    {
        int n;
        // Biến kiểm tra số nguyên n thỏa điều kiện, nếu biến này có giá trị false, người dùng phải nhập lại n
        boolean isNumericAndPositive;
        // Chuỗi người dùng nhập
        String inputString;
        int Sum = 0;

        // Kiểm tra số nguyên thỏa điều kiện
        do {
            System.out.println("Enter a number :");
            Scanner input = new Scanner(System.in);
            inputString = input.next();
            try {
                // Kiểm tra người dùng có nhập số nguyên không bằng try catch
                n = Integer.parseInt((inputString));
                if(n < 0)
                {
                    // Nếu nhập số âm thì cũng k thỏa điều kiện
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
                // nếu người dùng không nhập số nguyên, không thể parse từ chuỗi input sang int nên sẽ
                // chạy đoạn code ở catch
               System.out.println("Please enter a number");
               isNumericAndPositive = false;

            }
        }
        while(!isNumericAndPositive);

        System.out.println("Sum is : " + Sum);


    }
}
