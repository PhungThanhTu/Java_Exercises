package Models;

import java.util.Scanner;

public class Truck extends Vehicle{
    private double mileage;
    private String plateNumber;
    private int numSeats;
    private int numDoors;

    //<editor-fold desc="Constructors">
    public Truck() {
        this.mileage = 0;
        this.plateNumber = "undefined plate number";
        this.numSeats = 2;
        this.numDoors = 2;
    }

    public Truck(String model, String color, int year, int numWeight, double price, double weight, double mileage, String plateNumber, int numSeats, int numDoors) {
        super(model, color, year, numWeight, price, weight);
        this.mileage = mileage;
        this.plateNumber = plateNumber;
        this.numSeats = numSeats;
        this.numDoors = numDoors;
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">
    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileages) {
        this.mileage = mileages;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }
    //</editor-fold>


    public void transportGoods(String goodTypes, double load){
        System.out.println("Good type : " + goodTypes + ", load : " + load);
    }

    @Override
    public void turn() {
        System.out.println("Truck turns");
    }
    @Override
    public String toString() {
        return super.toString() + "";
    }

    @Override
    public double calcOdo() {
        return getMileage();
    }

    @Override
    public void insert() {
        System.out.println(" --- INSERT NEW CAR");
        super.insert();
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert mileage :");
        setMileage(sc.nextDouble());

        System.out.println("Insert plate number :");
        sc.nextLine();
        setPlateNumber(sc.nextLine());

        int valid = 0;
        do {
            System.out.println("Insert number of seats :");
            int inputSeats = sc.nextInt();
            if(inputSeats >= 0)
            {
                setNumSeats(inputSeats);
                valid = 1;
            }
            else {
                System.out.println("Invalid number of seats, please reenter");
            }
        }
        while(valid == 0);
        System.out.println("Insert number of doors :");
        setNumDoors(sc.nextInt());
    }
}
