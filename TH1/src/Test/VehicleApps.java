package Test;

import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleApps {

    static final int CURR_YEAR = 2021;

    public static void displayMainMenu()
    {
        System.out.println("--- MAIN MENU FOR PRO :");
        System.out.println("0. Exit program");
        System.out.println("1. Insert new vehicle");
        System.out.println("2. Display vehicle list");
        System.out.println("3. Display new vehicle list");
        System.out.println("4. Display total price");
        System.out.println("5. Display total mileage");
        System.out.println("Your choice ?");
    }

    public static void executeMainMenu(List<Vehicle> arr,int choice)
    {
        switch (choice)
        {

            case 1 -> {
                Scanner sc = new Scanner(System.in);
                int choice2 = -1;
                do {

                    displayInsertMenu();
                    choice2 = sc.nextInt();
                    executeInsertMenu(arr,choice2);
                } while (choice2 != 0);
            }
            case 2 -> {

                if(arr.size() == 0)
                {
                    System.out.println("No vehicle in list");
                }
                else {
                    for (Vehicle element: arr
                    ) {
                        element.print();
                    }
                }
            }
            case 3 -> {
                if(arr.size() == 0)
                {
                    System.out.println("No vehicle in list");
                }
                else {
                    for (Vehicle element: arr
                    ) {
                        if((CURR_YEAR - element.getYear()) <= 3){
                            element.print();
                        }
                    }
                }
            }
            case 4 -> {
                double sumPrice = 0;
                for (Vehicle element: arr
                     ) {
                    sumPrice += element.getPrice();
                }
                System.out.println("Total price value : " + sumPrice);
            }
            case 5 -> {
                double sumMileage = 0;
                for (Vehicle element: arr
                ) {
                    sumMileage += element.calcOdo();
                }
                double averageMileage = 0;
                if(arr.size() > 0)
                {
                    averageMileage = sumMileage/arr.size();
                }

                System.out.println("Average price value : " + averageMileage);
            }
            default-> {}

        }
    }

    public static void displayInsertMenu()
    {
        System.out.println("--- INSERT MENU FOR PRO :");
        System.out.println("0. Exit insert menu");
        System.out.println("1. Insert new Bike");
        System.out.println("2. Insert new Car");
        System.out.println("3. Insert new Bicycle");
        System.out.println("4. Insert new Truck");
        System.out.println("Your choice ?");
    }

    public static void executeInsertMenu(List<Vehicle> arr,int choice)
    {
       switch (choice)
       {
           case 1 -> {
               Vehicle newvehicle = new Bike();
               newvehicle.insert();
               arr.add(newvehicle);
           }
           case 2 -> {
               Vehicle newvehicle = new Car();
               newvehicle.insert();
               arr.add(newvehicle);
           }
           case 3 -> {
               Vehicle newvehicle = new Bicycle();
               newvehicle.insert();
               arr.add(newvehicle);
           }
           case 4 -> {
               Vehicle newvehicle = new Truck();
               newvehicle.insert();
               arr.add(newvehicle);
           }
           default -> {

           }
       }
    }

    public static void testProgram()
    {
        List<Vehicle> vehicles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            displayMainMenu();
            choice = sc.nextInt();
            executeMainMenu(vehicles,choice);
        }
        while (choice != 0);
    }

    public static void main(String[] args) {
       IFileManipulation.printString();
    }
}


