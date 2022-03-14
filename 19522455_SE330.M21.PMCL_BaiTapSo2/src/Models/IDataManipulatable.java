package Models;

import java.util.Scanner;

import static Library.StaticConsoleMethods.clearScreen;

/**
 * Interface to manage in/out and data change, also support console menu display
 */

public interface IDataManipulatable {

    /**
     *  Print Methods for Every class to implement
     */
    default void print() {
        System.out.println("Underfined");
    }

    /**
     * Insert method which can be implemented by all other class (in product and staff application)
     * Insert method in List classes is executed in constructor for save time
     */
    default void insert() {
        System.out.println("Defaul insert");
    }

    /**
     *
     * @return bill price if product, salary if staff
     */
    int getBills();

    /**
     * This is a part of data modifying menu, use to logically handle data modifying menu user input
     * It's created just for product app but if there's extend later (if require a data modifying function for staff, then
     * this method will be necessary
     * @param chosen number input by user
     */
    default  void dataChangeMenu(int chosen) {
        System.out.println(
                chosen
        );
    }

    /**
     * * This is a part of data modifying menu, use to display this menu
     *       It's created just for product app but if there's extend later (if require a data modifying function for staff, then
     *       this method will be necessary
     */
    default void displayChangeMenu() {
        System.out.println("Chon thong tin muon thay doi :");
    }

    /**
     *  This is a part of data modifying menu, use to implement dataChangeMenu and displayChangeMenu
     *  This method is an updating while loop
     */
    default void executeChangeMenu()
    {
        clearScreen();
        int chosen = -1;
        Scanner sc = new Scanner(System.in);
        do {
            displayChangeMenu();
            System.out.println("Lua chon cua ban : ");
            chosen = sc.nextInt();
            dataChangeMenu(chosen);
        } while (chosen != 0);

    }

    /**
     * This class is a menu for List class (StaffList and Product List, to create a menu to apply
     * required function (print, getBills, ....
     */
    default  void renderCustomMenu()
    {
        System.out.println("Does not contain custom menu");
    }
}
