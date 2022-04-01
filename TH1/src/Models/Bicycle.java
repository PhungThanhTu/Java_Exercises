package Models;

import java.util.Scanner;

public class Bicycle extends Vehicle{
    private double saddleSeatHeight;

    //<editor-fold desc="Constructors">
    public Bicycle() {
        this.saddleSeatHeight = 0.0;
    }

    public Bicycle(String model, String color, int year, int numWeight, double price, double weight, double saddleSeatHeight) {
        super(model, color, year, numWeight, price, weight);
        this.saddleSeatHeight = saddleSeatHeight;
    }
    //</editor-fold>


    //<editor-fold desc="Getters and Setters">
    public double getSaddleSeatHeight() {
        return saddleSeatHeight;
    }

    public void setSaddleSeatHeight(double saddleSeatHeight) {
        this.saddleSeatHeight = saddleSeatHeight;
    }
    //</editor-fold>

    @Override
    public void turn() {
        System.out.println("Bicycle turn");
    }

    @Override
    public String toString() {
        return super.toString() + "Bicycle{" +
                "saddleSeatHeight=" + saddleSeatHeight +
                '}';
    }

    @Override
    public double calcOdo() {
        return 0;
    }

    @Override
    public void insert() {
        System.out.println(" --- INSERT NEW BICYCLE");
        super.insert();
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert saddle height :");
        setSaddleSeatHeight(sc.nextDouble());

    }

    @Override
    public void importDataFromStringArray(String[] input) {
        super.importDataFromStringArray(input);
        setSaddleSeatHeight(Double.parseDouble(input[7]));
    }
}
