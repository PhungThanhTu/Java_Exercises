package Models;

import java.util.Scanner;

public class Truck extends Vehicle implements  IRemoteControlable,IInstallmentPayable{
    private double mileage;
    private String plateNumber;
    private int numSeats;
    private int numDoors;
    private int loadCapacity;
    private Television television;
    private Player player;

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

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
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
        return super.toString() + "Truck{LoadCapacity=" + loadCapacity + "}" ;
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

        valid = 0;
        do {
            System.out.println("Insert load capacity :");
            int loadCapacity = sc.nextInt();
            if(loadCapacity >= 0)
            {
                setLoadCapacity(loadCapacity);
                valid = 1;
            }
            else {
                System.out.println("Invalid load capacity, please reenter");
            }
        }
        while(valid == 0);

        System.out.println("Insert number of doors :");
        setNumDoors(sc.nextInt());
    }

    @Override
    public void importDataFromStringArray(String[] input) {
        super.importDataFromStringArray(input);
        this.setMileage(Double.parseDouble(input[7]));
        this.setPlateNumber(input[8]);
        this.setLoadCapacity(Integer.parseInt(input[9]));

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
        return getLoadCapacity() < 5000 ? 0.5*getPrice(): 0.4*getPrice();
    }
}
