package Models;

import java.util.Scanner;

/**
 * Vehicle class, abstract parent for all vehicle
 */
public abstract class Vehicle implements IMileageCalculator,IInsertAndPrint,IFileManipulation  {
    // data fields
    private String model;
    private String color;
    private int year;
    private int numWheels;
    private double price;
    private double weight;


    //<editor-fold desc="Constructors">
    public Vehicle() {
        this.model = "unknown";
        this.color = "undefined";
        this.year = 2000;
        this.numWheels = 4;
        this.price = 240;
        this.weight = 1000;
    }

    public Vehicle(String model, String color, int year, int numWeight, double price, double weight) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.numWheels = numWeight;
        this.price = price;
        this.weight = weight;
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //</editor-fold>

    public abstract void turn();
    @Override
    public String toString() {

        return "Vehicle{" +
                "model='" + model + '\'' +
                "color='" + color + '\'' +
                ", year=" + year +
                ", number of wheels =" + numWheels +
                ", price=" + price +
                ",weight=" + weight +
                '}';
    }

    @Override
    public void insert() {
        Scanner sc = new Scanner(System.in);
        int valid = 0;
        do {
            System.out.println("Insert model name : ");
            String name = sc.nextLine();
            if(IInsertAndPrint.checkValidModel(name))
            {
                setModel(name);
                valid = 1;
            }
            else {
                System.out.println("Invalid model name, please reenter");
            }
        }
        while(valid == 0);
        System.out.println("Insert color : ");
        setColor(sc.nextLine());

        valid = 0;
        do {
            System.out.println("Insert vehicle production year :");
            int inputYear = sc.nextInt();
            if(inputYear >= 1990)
            {
                setYear(inputYear);
                valid = 1;
            }
            else {
                System.out.println("Invalid year, please reenter");
            }
        }
        while(valid == 0);

        System.out.println("Insert number of wheels");
        setNumWheels(sc.nextInt());

        valid = 0;
        do {
            System.out.println("Insert price :");
            double inputPrice = sc.nextDouble();
            if(inputPrice >= 0)
            {
                setPrice(inputPrice);
                valid = 1;
            }
            else {
                System.out.println("Invalid price, please reenter");
            }
        }
        while(valid == 0);

        valid = 0;
        do {
            System.out.println("Insert weight :");
            double inputWeight = sc.nextDouble();
            if(inputWeight >= 0)
            {
                setWeight(inputWeight);
                valid = 1;
            }
            else {
                System.out.println("Invalid weight, please reenter");
            }
        }
        while(valid == 0);


    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public void importDataFromStringArray(String[] input) {
        this.setModel(input[1]);
        this.setColor(input[2]);
        this.setYear(Integer.parseInt(input[3]));
        this.setNumWheels(Integer.parseInt(input[4]));
        this.setPrice(Integer.parseInt(input[5]));
        this.setWeight(Double.parseDouble(input[6]));
    }
}

