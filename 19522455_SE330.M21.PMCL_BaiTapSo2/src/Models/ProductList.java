package Models;

import java.util.Scanner;

import static Library.StaticConsoleMethods.*;

/**
 * Manage product lists and their functions
 */

public class ProductList implements  IDataManipulatable{
    private final Product [] List;

    public ProductList() {
        System.out.println("Nhap so luong danh sach san pham :");
        Scanner sc = new Scanner(System.in);
        int listCount = sc.nextInt();
        List = new Product[listCount];
        insert();
    }
    public Product[] getList() {
        return List;
    }

    //<editor-fold desc="Methods">


    @Override
    public void print() {
        for (Product element: getList()
             ) {
            element.print();
        }
        System.out.println("Tong thanh tien : " + getBills());
    }

    @Override
    public void insert() {
        for (int i = 0, listLength = List.length; i < listLength; i++) {
            int chosen;
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("Chon loai san pham : ");
                System.out.println(" 0 - Sach");
                System.out.println(" 1 - Dia CD");
                chosen = sc.nextInt();
                switch (chosen) {
                    case 0 -> {
                       List[i] = new Book();
                       List[i].insert();

                    }
                    case 1 -> {
                        List[i] = new CD();
                        List[i].insert();
                    }
                    default -> System.out.println("KHONG HOP LE VUI LONG CHON LAI");
                }
            }
            while (chosen < 0 || chosen > 1);


        }
    }

    @Override
    public int getBills() {
        int totalBills = 0;
        for (Product element: List
             ) {
            totalBills += element.getBills();
        }
        return totalBills;
    }

    @Override
    public void dataChangeMenu(int chosen) {
        if(chosen >= List.length)
        {
            System.out.println(" So thu tu khong hop le, vui long nhap lai");
        }
        else
        {
            List[chosen].executeChangeMenu();
        }
    }

    @Override
    public void displayChangeMenu() {
        System.out.println("Nhap so thu tu phan tu muon thay doi, nhap -1 de ket thuc");
    }

    @Override
    public void executeChangeMenu() {
        clearScreen();
        int chosen;
        Scanner sc = new Scanner(System.in);
        do {
            displayChangeMenu();
            System.out.println("Lua chon cua ban : ");
            chosen = sc.nextInt();
            dataChangeMenu(chosen);
        } while (chosen != -1);
    }

    @Override
    public void renderCustomMenu() {
        clearScreen();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println(" --- PRODUCT MENU");
            System.out.println("0 - Thoat menu");
            System.out.println("1 - In ra man hinh toan bo du lieu");
            System.out.println("2 - In ra man hinh 1 phan tu");
            choice = sc.nextInt();

            switch (choice)
            {
                case 0 -> {
                    stop();
                }
                case 1 -> {
                    print();
                    stop();
                }
                case 2 -> {
                    System.out.println("Nhap so thu tu phan tu can in :");
                    int tempchoice = sc.nextInt();
                    if(tempchoice >= getList().length)
                    {
                        System.out.println("So thu tu khong hop le");
                    }
                    else
                    {
                        getList()[tempchoice].print();
                    }
                    stop();
                }

            }
        }
        while (choice != 0);
    }

    //</editor-fold>
}
