package Models;

import java.util.Scanner;

/**
 * Saler is one type of staffs who get salaried based on KPI and performance
 */
public class Saler extends Staff{
    private int KPI;
    private int NoProductSold;

    public Saler() {
        KPI = 0;
        NoProductSold = 0;
    }

    //<editor-fold desc="Getter and Setters">
    public int getKPI() {
        return KPI;
    }

    public void setKPI(int KPI) {
        this.KPI = KPI;
    }

    public int getNoProductSold() {
        return NoProductSold;
    }

    public void setNoProductSold(int noProductSold) {
        NoProductSold = noProductSold;
    }

    @Override
    public int getBasicSalary() {
        return 1000;
    }


    //</editor-fold>
    public double getSaleRatio()
    {
        return (NoProductSold * 1.0) / KPI;
    }
    @Override
    public int getBills() {
        int TempSalary = getType() == ContractType.Official ? getBasicSalary() : (int)(0.7 * getBasicSalary())+ 100;
        if(getSaleRatio() < 0) return 0;
        if(getSaleRatio() == 0 ) return TempSalary;
        if(getSaleRatio() < 0.5) return  TempSalary + 150;
        if(getSaleRatio() < 0.8) return  TempSalary + 300;
        if(getSaleRatio() < 0.9) return  TempSalary + 400;
        else return TempSalary + 550;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Loai : Nhan vien ban hang");
        System.out.println("So san pham da ban : " + NoProductSold);
        System.out.println("KPI : " + KPI);
    }

    @Override
    public void insert() {
        super.insert();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong san pham thuc ban : ");
        setNoProductSold(sc.nextInt());
        System.out.println("Nhap KPI : ");
        setKPI(sc.nextInt());

    }
}
