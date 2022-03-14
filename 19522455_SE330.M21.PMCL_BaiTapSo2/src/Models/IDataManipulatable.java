package Models;

import java.util.Scanner;

import static Library.StaticConsoleMethods.clearScreen;

/**
 * Interface to manage in/out and data change, also support console menu display
 */

public interface IDataManipulatable {
    default void print() {
        System.out.println("Underfined");
    }
    default void insert() {
        System.out.println("Defaul insert");
    }
    int getBills();

    default  void dataChangeMenu(int chosen) {
        System.out.println(
                chosen
        );
    }

    default void displayChangeMenu() {
        System.out.println("Chon thong tin muon thay doi : :");
    }

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

    default  void renderCustomMenu()
    {
        System.out.println("Does not contain custom menu");
    }
}
