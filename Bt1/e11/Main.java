package e11;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    /**
     *
     * @param min minimum value
     * @param max maximum value
     * @return random value from minimum to maximum
     */
    public static int getRandomInterger(int min,int max)
    {

        int range = max - min + 1;

            int rand = (int)(Math.random() * range) + min;


        return rand;
    }
    /**
     * Bài 11 : Thao tác trên mảng số nguyên
     */
    public static void main(String args[])
    {
        // Khai báo Scanner
        Scanner sc = new Scanner(System.in);
        // Nhập kích thước a và b
        int n;
        int m;
        System.out.println("Insert n and m :");
        n = sc.nextInt();
        m = sc.nextInt();
        // Khai báo 2 mảng số nguyên
        int[] a = new int[n];
        int[] b = new int[m];
        // Nhập mảng số nguyên a
        System.out.println("Insert elements of a : ");
        for(int i = 0 ; i < n ; i ++)
        {
            System.out.println("Insert element " + i + " : ");
            a[i] = sc.nextInt();
        }
        // Random mảng b (random từ 0 tới 99
        for( int i = 0 ; i < m ; i ++)
        {


            b[i] = getRandomInterger(0,100);
        }
        // In mảng b ra màn hình
        System.out.println("Array b : ");
        System.out.println(Arrays.toString(b));
        // Tạo mảng c từ mảng a
        int[] c = Arrays.copyOf(a,n);
        // Thay thế 3 phần tử đầu của mảng a thành 3 phần tử cuối của mảng b
        System.arraycopy(b,m-3,a,0,3);
        System.out.println("Array a after manipulation : ");
        System.out.println(Arrays.toString(a));
        // Sắp xếp mảng c tăng dần
        Arrays.sort(c);
        // và in c ra màn hình
        System.out.println("After sort : ");
        System.out.println(Arrays.toString(c));
        // Nhập vào số x
        System.out.println("Insert x : ");
        int x;
        x = sc.nextInt();
        // Kiểm tra số x có nằm trong mảng c không
        int result = Arrays.binarySearch(c,x);
        if(result < 0)
        {
            System.out.println("No x in a");
        }
        else
        {
            System.out.println("x in a");
        }

    }
}
