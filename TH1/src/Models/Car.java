package Models;

import java.util.Scanner;

public class Car extends Vehicle implements IFileManipulation,IRemoteControlable,IInstallmentPayable {

    private double mileage;
    private int numSeats;
    private int numDoors;
    private String plateNumber;
    private Player player;
    private Television television;

    //<editor-fold desc="Constructors">
    public Car() {
        super();
        this.mileage = 0;
        this.numSeats = 4;
        this.numDoors = 4;
    }

    public Car(String model, String color, int year, int numWeight, double price, double weight, double mileage, int numSeats, int numDoors) {
        super(model, color, year, numWeight, price, weight);
        this.mileage = mileage;
        this.numSeats = numSeats;
        this.numDoors = numDoors;
    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    //</editor-fold>

    @Override
    public void turn() {
        System.out.println("Car turned");
    }

    @Override
    public String toString() {
        return super.toString() + "Car{" +
                "mileage=" + mileage +
                ", numSeats=" + numSeats +
                ", numDoors=" + numDoors +
                '}';

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

        valid = 0;
        do {
            System.out.println("Insert number of doors :");
            int inputDoors = sc.nextInt();
            if(inputDoors == 2 || inputDoors == 4)
            {
                setNumDoors(inputDoors);
                valid = 1;
            }
            else {
                System.out.println("Invalid number of doors, please reenter");
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
        this.setNumDoors(Integer.parseInt(input[10]));
    }

    @Override
    public void Start() {
        television.turnOn();
        player.turnOn();
    }

    @Override
    public void Stop() {
       television.turnOff();
       player.turnOff();
    }

    @Override
    public void VolumeUp() {
        television.volumeUp();
        player.volumeUp();
    }

    @Override
    public void VolumeDown() {
        television.volumeDown();
        player.volumeDown();
    }

    @Override
    public double postpaidPrice() {
        return getNumDoors() == 2 ? 0.6*getPrice() : 0.65*getPrice();
    }
}
