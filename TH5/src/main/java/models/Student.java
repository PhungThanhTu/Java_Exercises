package models;

import java.sql.SQLData;
import java.util.Scanner;

public class Student implements IStreamable {
    private String student_id;
    private String first_name;
    private String last_name;
    private String dob;
    private String department;
    private String entrance_date;
    private String graduation_date;
    private int credits;
    private float score;

    /**
     *
     */
    public Student() {
        this.student_id = "K000";
        this.first_name = "John";
        this.last_name = "Doe";
        this.dob = "2001-01-01";
        this.department = "Unknown";
        this.entrance_date ="2001-01-01";
        this.graduation_date = "2003-01-01";
        this.credits = 0;
        this.score = 0.0f;
    }

    public Student(String student_id, String first_name, String last_name, String dob, String department, String entrance_date, String graduation_date, int credits, float score) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.department = department;
        this.entrance_date = entrance_date;
        this.graduation_date = graduation_date;
        this.credits = credits;
        this.score = score;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEntrance_date() {
        return entrance_date;
    }

    public void setEntrance_date(String entrance_date) {
        this.entrance_date = entrance_date;
    }

    public String getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob='" + dob + '\'' +
                ", department='" + department + '\'' +
                ", entrance_date='" + entrance_date + '\'' +
                ", graduation_date='" + graduation_date + '\'' +
                ", credits=" + credits +
                ", score=" + score +
                '}';
    }

    @Override
    public void Insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert id : ");
        setStudent_id(sc.nextLine());
        System.out.println("Insert first name :");
        setFirst_name(sc.nextLine());
        System.out.println("Insert last name :");
        setLast_name(sc.nextLine());
        String dateOB;
        DateValidator validator = new DateValidator("yyyy-MM-dd");
        do {
            System.out.println("Insert date of birth : ");
            dateOB = sc.nextLine();
            if(!validator.isValid(dateOB)) System.out.println("Invalid date format, please try again");
        }
        while(!validator.isValid(dateOB));
        System.out.println("Insert department :");
        setDepartment(sc.nextLine());

        String dateEntrance;
        do {
            System.out.println("Insert date of entrance : ");
            dateEntrance = sc.nextLine();
            if(!validator.isValid(dateEntrance)) System.out.println("Invalid date format, please try again");
        }while(!validator.isValid(dateEntrance));

        // this can be null
        String dateGraduation;
        do {
            System.out.println("Insert date of graduation : ");
            dateGraduation = sc.nextLine();
            if(dateGraduation.equals("null"))
            {
                setGraduation_date(null);
                break;
            }
            if(!validator.isValid(dateGraduation)) System.out.println("Invalid date format, please try again");
        }while(!validator.isValid(dateGraduation));

        int credits;
        do {
            try {
                System.out.println("Insert credits :");
                credits = Integer.parseInt(sc.nextLine());
                setCredits(credits);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid number format, please try again");
            }
        }
        while(true);

        float score;

        do {
            try {
                System.out.println("Insert score :");
                score = Float.parseFloat(sc.nextLine());
                setScore(score);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid decimal format, please try again");
            }
        }
        while(true);
    }

    @Override
    public void Update(){
        Scanner sc = new Scanner(System.in);
        DateValidator validator = new DateValidator("yyyy-MM-dd");
        while(true)
        {
            System.out.println("Choose property to update :");
            System.out.println("1 - Firtst name");
            System.out.println("2 - Last name");
            System.out.println("3 - date of birth");
            System.out.println("4 - department");
            System.out.println("5 - date of entrance");
            System.out.println("6 - date of graduation");
            System.out.println("7 - credits");
            System.out.println("8 - score");
            System.out.println("0 - Done editing");
            System.out.println("Your choice : ");
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Wrong format, please enter a number");
                continue;
            }
            switch (choice)
            {
                case 1 :{
                    System.out.println("Insert first name :");
                    setFirst_name(sc.nextLine());
                    break;
                }
                case 2 :{
                    System.out.println("Insert last name :");
                    setLast_name(sc.nextLine());
                    break;
                }
                case 3: {
                    String dateOB;

                    do {
                        System.out.println("Insert date of birth : ");
                        dateOB = sc.nextLine();
                        if(!validator.isValid(dateOB)) System.out.println("Invalid date format, please try again");
                    }
                    while(!validator.isValid(dateOB));
                    break;
                }
                case 4:{
                    System.out.println("Insert department :");
                    setDepartment(sc.nextLine());
                    break;

                }
                case 5:{
                    String dateEntrance;
                    do {
                        System.out.println("Insert date of entrance : ");
                        dateEntrance = sc.nextLine();
                        if(!validator.isValid(dateEntrance)) System.out.println("Invalid date format, please try again");
                    }while(!validator.isValid(dateEntrance));
                    break;
                }
                case 6:{
                    // this can be null
                    String dateGraduation;
                    do {
                        System.out.println("Insert date of graduation : ");
                        dateGraduation = sc.nextLine();
                        if(dateGraduation == "null")
                        {
                            setGraduation_date(null);
                            break;
                        }
                        if(!validator.isValid(dateGraduation)) System.out.println("Invalid date format, please try again");
                    }while(!validator.isValid(dateGraduation));
                    break;
                }
                case 7:{
                    int credits;
                    do {
                        try {
                            System.out.println("Insert credits :");
                            credits = Integer.parseInt(sc.nextLine());
                            setCredits(credits);
                            break;
                        }
                        catch (NumberFormatException e){
                            System.out.println("Invalid number format, please try again");
                        }
                    }
                    while(true);
                }
                case 8:{
                    float score;

                    do {
                        try {
                            System.out.println("Insert score :");
                            score = Float.parseFloat(sc.nextLine());
                            setScore(score);
                            break;
                        }
                        catch (NumberFormatException e){
                            System.out.println("Invalid decimal format, please try again");
                        }
                    }
                    while(true);
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.print("Wrong command, please try again.");
                }
            }
        }












    }

    @Override
    public void Print() {
       System.out.print(student_id + "\t\t\t" + first_name + "\t\t\t" + last_name + "\t\t\t" + dob + "\t\t\t" + department + "\t\t\t" + entrance_date + "\t\t\t"
       + graduation_date + "\t\t\t" + credits + "\t\t\t" + score + "\n");
    }
}
