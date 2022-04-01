package Models;

import java.util.Scanner;

/**
 * Child of a vehicle
 */
public class Bike extends Vehicle{

    double mileage;
    String plateNumber;
    int numSeats;

    //<editor-fold desc="Constructors">
    public Bike() {
        this.mileage = 0;
        this.plateNumber = "undefined plate number";
        this.numSeats = 2;
    }

    public Bike(String model, String color, int year, int numWeight, double price, double weight, double mileage, String plateNumber, int numSeats) {
        super(model, color, year, numWeight, price, weight);
        this.mileage = mileage;
        this.plateNumber = plateNumber;
        this.numSeats = numSeats;
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">
    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
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
    //</editor-fold>

    @Override
    public void turn() {
        System.out.println("Bike turns");
    }
    @Override
    public String toString()
    {
        return super.toString() + "Bike{" +
                "mileage=" + mileage +
                ", numSeats=" + numSeats +
                ", plateNumber=" + plateNumber +
                '}';
    }

    @Override
    public double calcOdo() {
        return getMileage();
    }

    @Override
    public void insert() {
        System.out.println(" --- INSERT NEW BIKE");
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

    }

    @Override
    public void importDataFromStringArray(String[] input) {
        super.importDataFromStringArray(input);
        this.setMileage(Double.parseDouble(input[7]));
        this.setPlateNumber(input[8]);
        this.setNumSeats(Integer.parseInt(input[9]));
    }
}
