package Models;

import java.util.List;
import java.util.Scanner;

import static Library.StaticConsoleMethods.clearScreen;
import static Library.StaticConsoleMethods.stop;

public class StaffList implements IDataManipulatable {
    //<editor-fold desc="Fields">
    private Staff[] List;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public StaffList() {
        System.out.println("Insert number of staffs ");
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List = new Staff[n];
        insert();
    }
    //</editor-fold>

    //<editor-fold desc="Getter and setters">
    public Staff[] getList() {
        return List;
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    @Override
    public int getBills() {
        int SumBills = 0;
        for (Staff element: List
             ) {
            SumBills += element.getBills();
        }
        return SumBills;
    }

    @Override
    public void print() {
        for (Staff element: List
             ) {
            element.print();
        }
    }

    @Override
    public void insert() {
        // cannot insert data with foreach
        for(int i = 0 ; i < List.length; i ++ )
        {
            int chosen;
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("Chon loai nhan vien : ");
                System.out.println(" 0 - Quan ly");
                System.out.println(" 1 - Ban hang");
                chosen = sc.nextInt();
                switch (chosen) {
                    case 0 -> {
                        List[i] = new Manager();
                        List[i].insert();

                    }
                    case 1 -> {
                        List[i] = new Saler();
                        List[i].insert();
                    }
                    default -> System.out.println("KHONG HOP LE VUI LONG CHON LAI");
                }
            }
            while (chosen < 0 || chosen > 1);
        }
    }

    @Override
    public void renderCustomMenu() {
        clearScreen();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println(" ---STAFF MENU");
            System.out.println("0 - Thoat menu");
            System.out.println("1 - In ra man hinh toan bo du lieu");
            System.out.println("2 - In ra man hinh 1 phan tu");
            System.out.println("3 - In ra tong luong");
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
                case 3 -> {
                    System.out.println("Tong luong cac nhan vien la " + getBills());
                }

            }
        }
        while (choice != 0);
    }
    //</editor-fold>
}
