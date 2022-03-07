package e9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * Bài 9
     * Xử lí chuỗi
     */

    public static void main(String args[])
    {
        String x;
        String y;
        /**
         * Nhập dữ liệu đầu vào
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert String X : ");
        x = sc.nextLine();
        System.out.println("Insert String Y : ");
        y = sc.nextLine();
        /**
         * Tính tổng chiều dài của 2 chuỗi
         */
        System.out.println("Sum length : " + (x.length() + y.length()));

        /**
         * tính 3 Kí tự đầu của chuỗi x và 3 kí tữ cuối của chuỗi y
         */
        String XSubString = x.substring(0,3);
        String YSubString = y.substring(y.length() - 3);
        System.out.println("x 3 first chars : " + XSubString);
        System.out.println("y 3 last char : " + YSubString);
        /**
         * Tìm kí tự thứ 6 của x
         */
        System.out.println(" x 6th char : " + x.charAt(5));
        String SumString = x.substring(0,2) + YSubString;
        /**
         * Tạo chuỗi mới gồm 3 kí tự đầu tiên của chuỗi x và 3 kí tự cuối của chuỗi y
         */
        System.out.println("x 3 first + y 3 last : " + SumString);

        /**
         * Kiểm tra 2 chuỗi x, y có bằng nhau hay không (phân biệt chữ hoa,
         * thường)?
         * (Hướng dẫn: sử dụng hàm equals)
         */
        if(x.equals(y))
        {
            System.out.println("2 strings are equal case-sensitively");
        }
        else
        {
            System.out.println("2 strings are unequal case-sensitively");
        }

        /**
         * Kiểm tra 2 chuỗi x, y có bằng nhau hay không (không phân biệt
         * chữ hoa, thường)
         */
        if(x.equalsIgnoreCase(y))
        {
            System.out.println("2 strings are equal case-insensitively");
        }
        else
        {
            System.out.println("2 strings are unequal case-insensitively");
        }
        /**
         * Cho biết y có xuất hiện trong x hay không? Nếu có, tại vị trí nào?
         * (Hướng dẫn: sử dụng hàm indexOf)
         */
        int indx = x.indexOf(y);
        if(indx == -1)
        {
            System.out.println("there's no y in x");
        }
        else
        {
            System.out.println("There's y in x at " + indx);
        }

        /**
         * Cho biết tất cả các vị trí xuất hiện của y trong x?
         */
        int numSubStr = 0;
        int flag = 0;
        ArrayList ListSubPos = new ArrayList();
        flag = x.indexOf(y,flag);
        if(flag != -1)
        {
            int tempFlag = flag;
            ListSubPos.add(tempFlag);
            numSubStr++;
        }
        while (flag != -1)
        {
            flag = x.indexOf(y,flag+1);
            if(flag != -1)
            {
                int tempFlag = flag;
                ListSubPos.add(tempFlag);
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
            System.out.println("At position : ");
            for(int i = 0; i < ListSubPos.size();i++)
            {
                System.out.println(ListSubPos.get(i));
            }
        }
    }
}
