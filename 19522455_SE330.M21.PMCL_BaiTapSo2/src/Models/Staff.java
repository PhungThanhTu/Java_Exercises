package Models;

import java.util.Scanner;

enum ContractType {
    Official,
    Intern
}

/**
 * Staff abstract class for managing many types of staffs
 */
public abstract  class Staff implements IDataManipulatable{

    //<editor-fold desc="Fields">
    private int Id;
    private String Name;
    private ContractType type;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Staff() {
        Id = 0;
        Name = "undefined staff name";
        this.type = ContractType.Official;
    }
    //</editor-fold>

    //<editor-fold desc="Getters and setters">
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

    public ContractType getType() {
        return type;
    }

    public void setType(ContractType type) {
        this.type = type;
    }

    // abstract getter
    public abstract int getBasicSalary();

    //</editor-fold>


    @Override
    public void print() {
        System.out.println("--- Thong tin nhan vien  " + getName());
        System.out.println("Ma so " + getId());
        System.out.println("Loai hop dong :" + (type == ContractType.Intern ? "Thu viec" : "Chinh thuc"));
        System.out.println("MUC LUONG HANG THANG : " + getBills());
    }

    @Override
    public void insert() {
        System.out.println("-- Nhap thong tin nhan vien : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Id : ");
        setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Ten :");
        setName(sc.nextLine());
        System.out.println("Loai hop dong : 0 - thu viec, so khac - chinh thuc");
        if (sc.nextInt() == 0) setType(ContractType.Intern);
        else setType(ContractType.Official);

    }


}
