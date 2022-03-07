package e10;

import java.util.Calendar;
import java.util.Scanner;
import java.time.YearMonth;

public class Main {

    /**
     * Bài 10
     * Sử dụng thư viện Calendar và kiểu dữ liệu Calendar để thực hiện một số bài toán liên
     * quan đến ngày tháng năm
     * Hàm Main
     */

    public static void main(String args[])
    {
        /**
         * Khai báo 2 biến cần xét
         * */
        Calendar a = Calendar.getInstance();
        Calendar b = Calendar.getInstance();

        /**
         * Nhập và kiểm tra dữ liệu đầu vào
         * */
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Insert time of a : ");
            int day_a = sc.nextInt();
            int month_a = sc.nextInt() - 1;
            int year_a = sc.nextInt();




            System.out.println("Insert time of b : ");
            int day_b = sc.nextInt();
            int month_b = sc.nextInt() - 1;
            int year_b = sc.nextInt();
            a.set(year_a, month_a, day_a);
            b.set(year_b, month_b, day_b);

            /**
             * Sử dụng biến isValid để kiểm tra dữ liệu hợp lệ
             */
            isValid = true;

            // Cứ mỗi điều kiện không thỏa, dữ liệu sẽ k còn hợp lệ
            if(month_a < 0 || month_b < 0 || day_a < 0 || day_b < 0)
            {
                isValid = false;
            }

            if(month_a > 12 || day_a > YearMonth.of(year_a,month_a+1).lengthOfMonth())
            {
                isValid = false;
            }
            if(month_b > 12 || day_b > YearMonth.of(year_b,month_b+1).lengthOfMonth())
            {
                isValid = false;
            }
        }


        /**
         * Xét 2 biến bằng nhau (ngày,tháng,năm)
         */

        if(a.get(Calendar.DAY_OF_MONTH) == b.get(Calendar.DAY_OF_MONTH)
        && a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.YEAR) == b.get(Calendar.YEAR))
        {
            System.out.println("a is equal to b");
        }
        else
        {
            System.out.println("a is not equal to b");
        }

        /**
         * Tính và in ra ngày tiếp theo và ngày trước đó
         */

        a.add(Calendar.DATE,1);
        System.out.println("Next day of a is :" + a.get(Calendar.DAY_OF_MONTH) + " " + (a.get(Calendar.MONTH)+1) + " " + a.get(Calendar.YEAR));
        a.add(Calendar.DATE,-2);
        System.out.println("Previous day of a is :" + a.get(Calendar.DAY_OF_MONTH) + " " + (a.get(Calendar.MONTH)+1) + " " + a.get(Calendar.YEAR));
        // Trả về ban đầu
        a.add(Calendar.DATE,1);

        /**
         *  Tính xem a là ngày thứ mấy trong năm
         */

        int DayOfYear = a.get(Calendar.DAY_OF_YEAR);
        System.out.println("Index of a in year is : " + DayOfYear);
        /**
         * Tính xem tháng chứa a có bao nhiêu ngày
         */

        int NumberOfDayInMonth = YearMonth.of(a.get(Calendar.YEAR),(a.get(Calendar.MONTH)+1)).lengthOfMonth();
        System.out.println("Month of a contains :" + NumberOfDayInMonth + " days");
        /**
         * Cho biết năm chứa a có phải năm nhuận hay không
         */
        int YearA = a.get(Calendar.YEAR);
        boolean isLeapYear = false;
        if( YearA % 4 == 0)
        {
            isLeapYear = true;
        }
        if(YearA % 100 == 0)
        {
            isLeapYear = false;
        }
        if(YearA % 400 == 0)
        {
            isLeapYear = true;
        }
        if(isLeapYear)
        {
            System.out.println("Year of a is leap year");
        }
        else
        {
            System.out.println("Year of a is not leap year");
        }
    }
}
