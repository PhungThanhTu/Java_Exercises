package Models;

import java.io.*;

public interface IFileManipulation {
    public static final String filePath = "Vehicle.txt";

    public static void printString(){
        FileReader reader = null;
        BufferedReader buffered_reader = null;
        try {
            reader = new FileReader("Vehicle.txt");
            buffered_reader = new BufferedReader(reader);
            while(buffered_reader.ready()){
                String s = buffered_reader.readLine();
                s = s.replace("[","");
                s = s.replace("]","");
                String[] a = s.split(" ");
                switch (a[0]){
                    case "Car" -> {
                        Car newcar = new Car();
                        newcar.importDataFromStringArray(a);
                        System.out.println(newcar.toString());
                    }
                    case "Bike" -> {
                        Bike newbike = new Bike();
                        newbike.importDataFromStringArray(a);
                        System.out.println(newbike.toString());
                    }
                    case "Truck" -> {
                        Truck truckkun = new Truck();
                        truckkun.importDataFromStringArray(a);
                        System.out.println(truckkun.toString());
                    }
                    case "Bicycle" -> {
                        Bicycle newbicycle = new Bicycle();
                        newbicycle.importDataFromStringArray(a);
                        System.out.println(newbicycle.toString());
                    }

                    default -> {
                        System.out.println("Invalid data");
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTestFile() {
        try {
            File myObj = new File("BUOI.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void importDataFromStringArray(String[] input);
}
