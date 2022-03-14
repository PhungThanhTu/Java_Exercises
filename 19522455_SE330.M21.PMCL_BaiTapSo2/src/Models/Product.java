package Models;

import java.util.Scanner;

/**
 * Abstract class Models.Product
 * Contain data for products in the store
 */

public abstract class Product implements IDataManipulatable {
    //<editor-fold desc="Fields">
    private int Id;
    private String Name;
    private int Year;
    private int Price;
    private int Count;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Product() {
        Id = -1;
        Name = "undefined";
        Year = 1900;
        Price = 0;
        Count = 0;
    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    @Override
    public void print() {
        System.out.println(" -- thong tin san pham : " + getName());
        System.out.println(" ID : " + getId());
        System.out.println("Nam : " + getYear());
        System.out.println("Don gia : " + getPrice());
        System.out.println("So luong : " + getCount());
    }

    @Override
    public void insert() {
       Scanner sc = new Scanner(System.in);
       System.out.println("--- Nhap thong tin san pham : ");
       System.out.println("Id : ");
       setId(sc.nextInt());
       sc.nextLine();
       System.out.println("Ten : ");
       setName(sc.nextLine());
       System.out.println("Nam : ");
       setYear(sc.nextInt());
       System.out.println("Gia : ");
       setPrice(sc.nextInt());
       System.out.println("So luong : ");
       setCount(sc.nextInt());
    }

    @Override
    public void displayChangeMenu() {
        IDataManipulatable.super.displayChangeMenu();
        System.out.println("0 - Ngung thay doi");
        System.out.println("1 - Ten  ");
        System.out.println("2 - Nam ");
        System.out.println("3 - Don Gia  ");
        System.out.println("4 - So luong ");
    }

    @Override
    public void dataChangeMenu( int chosen) {
        Scanner sc = new Scanner(System.in);
        switch (chosen)
        {
            case 0 : break;
            case 1 : {
                System.out.println("Nhap ten : ");
                setName(sc.nextLine());
                break;
            }
            case 2 : {
                System.out.println("Nhap nam : ");
                setYear(sc.nextInt());
                break;
            }
            case 3 : {
                System.out.println("Nhap don gia : ");
                setPrice(sc.nextInt());
                break;
            }
            case 4 : {
                System.out.println("Nhap so luong : ");
                setCount(sc.nextInt());
                break;
            }
            default: break;
        }
    }
    //</editor-fold>
}
