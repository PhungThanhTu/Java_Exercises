package Models;

import java.util.Scanner;

/**
 * Class CD is child class of Product
 */

public class CD extends Product {
    //<editor-fold desc="Fields">
    private String RecordLabel;
    private String Singer;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public CD() {
        RecordLabel = "undefined record label";
        Singer = "undefined singer";
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">
    public String getRecordLabel() {
        return RecordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        RecordLabel = recordLabel;
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }
    //</editor-fold>


    //<editor-fold desc="Methods">
    @Override
    public void print() {
        super.print();
        System.out.println("Hang thu am : " + getRecordLabel());
        System.out.println("Ca si : "+ getSinger());
        System.out.println("Thanh tien : " + getBills());
    }

    @Override
    public void insert() {
        super.insert();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hang thu am : ");
        setRecordLabel(sc.nextLine());
        System.out.println("Ca si : ");
        setSinger(sc.nextLine());

    }

    @Override
    public void displayChangeMenu() {
        super.displayChangeMenu();
        System.out.println("5 - Hang thu am");
        System.out.println("6 - Ca si");

    }

    @Override
    public void dataChangeMenu(int chosen) {
        super.dataChangeMenu(chosen);
        if(chosen > 4) {
            Scanner sc = new Scanner(System.in);
            switch (chosen) {
                case 5 -> {
                    System.out.println("Nhap hang thu am :");
                    setRecordLabel(sc.nextLine());

                }
                case 6 -> {
                    System.out.println("Nhap ca si :");
                    setSinger(sc.nextLine());

                }
                default -> {
                    System.out.println("Lua chon khong hop le, nhap so bat ki de tiep tuc");
                    sc.nextInt();
                }
            }
        }
    }

    @Override
    public int getBills() {
        return getYear() < 1990 ? (int)(getPrice()*getCount()*0.9) : getPrice()*getCount();
    }
    //</editor-fold>


}
