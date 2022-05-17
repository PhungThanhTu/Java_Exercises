package controllers;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import models.DAO;
import models.Student;
import models.Variables;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO implements DAO {
    public ArrayList<Student> students;

    public StudentDAO() {
       students = new ArrayList<>();
    }

    @Override
    public Connection getConnection() {
        try {
            Class . forName(Variables.DBDriver); // load the driver for postgres
             } catch (ClassNotFoundException ex) {
             ex. printStackTrace () ;
            }

        Connection con;

        try
        {   con = DriverManager.getConnection(Variables.urlDB,Variables.usernameDB,Variables.passwordDB);
            return con;

            } catch (SQLServerException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }


    }
    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        String query = "select * from students";
        try(Connection con = getConnection(); Statement stm = con.createStatement();ResultSet resultSet = stm.executeQuery(query)) {
            while(resultSet.next())
            {
                String studentID = resultSet.getString("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String dOB = resultSet.getString("dob");
                String department = resultSet.getString("department");
                String entranceDate = resultSet.getString("entrance_date");
                String graduation_date = resultSet.getString("graduation_date");
                int credit = resultSet.getInt("credits");
                float score = resultSet.getFloat("score");
                Student newStudent = new Student(studentID,firstName,lastName,dOB,department,entranceDate,graduation_date,credit,score);
                students.add(newStudent);

            }
            return students;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Student get(String id) {

        String query = "select * from students where student_id = ?";
        try( Connection con = getConnection();PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next())
            {
                String studentID = resultSet.getString("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String dOB = resultSet.getString("dob");
                String department = resultSet.getString("department");
                String entranceDate = resultSet.getString("entrance_date");
                String graduation_date = resultSet.getString("graduation_date");
                int credit = resultSet.getInt("credits");
                float score = resultSet.getFloat("score");
                Student newStudent = new Student(studentID,firstName,lastName,dOB,department,entranceDate,graduation_date,credit,score);
                return newStudent;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public void add(Object o) {
        Student newStudent = (Student) o;
        if(get(newStudent.getStudent_id())!=null){
            System.out.println("This id has already existed");
            return;
        }
        String query = "INSERT INTO students (\t\n" +
                "\t\t\t\t\tstudent_id, \n" +
                "\t\t\t\t\tfirst_name, \n" +
                "\t\t\t\t\tlast_name, \n" +
                "\t\t\t\t\tdob, \n" +
                "\t\t\t\t\tdepartment, \n" +
                "\t\t\t\t\tentrance_date, \n" +
                "\t\t\t\t\tgraduation_date,\n" +
                "\t\t\t\t\tcredits, \n" +
                "\t\t\t\t\tscore) \n" +
                "\t\t\t\tVALUES \n" +
                "\t\t\t\t\t(?,?,?,?,?,?,?,?,?);";
        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(query);

                ){
                ps.setString(1,newStudent.getStudent_id());
                ps.setString(2,newStudent.getFirst_name());
                ps.setString(3,newStudent.getLast_name());
                ps.setString(4,newStudent.getDob());
                ps.setString(5,newStudent.getDepartment());
                ps.setString(6,newStudent.getEntrance_date());
                ps.setString(7,newStudent.getGraduation_date());
                ps.setInt(8,newStudent.getCredits());
                ps.setFloat(9,newStudent.getScore());
                ps.executeUpdate();
                System.out.println("Student added successfully");
                return;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Error occurred adding student");
            return;
        }

    }

    @Override
    public void update(Object o) {
        Student newStudent = (Student) o;
        if(get(newStudent.getStudent_id())==null){
            System.out.println("Student not exists to update");
            return;
        }
        String query = "update students \n" +
                "\t\tset first_name = ?,\n" +
                "\t\tlast_name = ?,\n" +
                "\t\tdob = ?,\n" +
                "\t\tdepartment = ?,\n" +
                "\t\tentrance_date = ?,\n" +
                "\t\tgraduation_date = ?,\n" +
                "\t\tcredits = ?,\n" +
                "\t\tscore = ?\n" +
                "\t\twhere student_id = ?";

        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(query);

        ){
            ps.setString(9,newStudent.getStudent_id());
            ps.setString(1,newStudent.getFirst_name());
            ps.setString(2,newStudent.getLast_name());
            ps.setString(3,newStudent.getDob());
            ps.setString(4,newStudent.getDepartment());
            ps.setString(5,newStudent.getEntrance_date());
            ps.setString(6,newStudent.getGraduation_date());
            ps.setInt(7,newStudent.getCredits());
            ps.setFloat(8,newStudent.getScore());
            ps.executeUpdate();
            System.out.println("Student updated successfully");
            return;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Error occurred adding student");
            return;
        }

    }

    @Override
    public void delete(String id) {

        if(get(id) == null)
        {
            System.out.print("Nothing to delete");
            return;
        }

        String query = "delete from students where student_id = ?";

        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(query);
        ){
            ps.setString(1,id);
            ps.executeUpdate();
            System.out.println("Deleted successfully.");
            return;
        }
        catch (SQLException e)
        {
            System.out.println("Could not delete student, error");
            return;
        }

    }
}
