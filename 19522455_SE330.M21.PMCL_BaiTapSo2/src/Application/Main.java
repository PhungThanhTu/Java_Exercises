package Application;

import Models.Book;
import Models.ProductList;
import Models.StaffList;

import java.util.Scanner;

/**
 * Entry file
 */
public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int choice;

        // While update Loop
        do {
            // Display menu
            System.out.println("-- MAIN MENU");
            System.out.println("Choose your option : ");
            System.out.println("0 - Exit the program");
            System.out.println("1 - Product Application");
            System.out.println("2 - Staff Application");
            System.out.println("What is your option ? ");
            choice = sc.nextInt();
            switch (choice)
            {
                case 0 -> {}
                case 1 -> {
                    ProductList productlist = new ProductList();
                    productlist.renderCustomMenu();
                }
                case 2 -> {
                    StaffList staffList = new StaffList();
                    staffList.renderCustomMenu();
                }
                default -> {
                    System.out.println("Invalid option");
                }

            }
        } while(choice != 0);
    }
}
