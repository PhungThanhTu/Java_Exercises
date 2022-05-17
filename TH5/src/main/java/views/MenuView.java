package views;

import controllers.StudentDAO;
import models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {

    /**
     * Display the main menu for the application
     */
    public static void displayMainMenu()
    {
        System.out.println("Please input your choice (>=5 to exit):");
        System.out.println("1. View all");
        System.out.println("2. Add");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit app");
        System.out.println("Your choice ? ");
    }

    /**
     * Execute the menu by choice and through DAO
     * @param choice choice to execute
     * @param student DAO to interact with
     */
    public static void executeMenu(int choice, StudentDAO student)
    {
        switch (choice){
            case 1 :{
                ArrayList<Student> students;
                students = student.getAll();
                if(students != null)
                {
                    for(int i = 0; i < students.size();i++)
                    {
                        students.get(i).Print();
                    }
                }
                break;
            }
            case 2 : {
                Student newStudent = new Student();
                newStudent.Insert();
                student.add(newStudent);
                break;
            }
            case 3:{
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter id to update :");
                String id = sc.nextLine();
                Student updtStu = student.get(id);
                if(updtStu==null){
                    System.out.println("Id not available");
                    break;
                }
                updtStu.Update();
                student.update(updtStu);
                break;
            }
            case 4:{
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter id to delete :");
                String id = sc.nextLine();
                student.delete(id);
                break;
            }
            default:{
                break;
            }
        }
    }


}
