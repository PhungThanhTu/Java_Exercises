package Library;

import java.util.Scanner;


/**
 * Static console methods to handle console, currently to clear screen and hold screen
 */

public class StaticConsoleMethods {
    public static void clearScreen() { // This didn't work
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void stop()
    {   // This function is currently redundant due to that clear screen didn't work
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so bat ky de tiep tuc ...");
        sc.next();
    }
}
