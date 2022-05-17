import com.microsoft.sqlserver.jdbc.SQLServerException;
import models.Student;
import controllers.StudentDAO;
import views.MenuView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String urlDB = "jdbc:sqlserver://sql8001.site4now.net;encrypt=true;trustServerCertificate=true;";
    static String dbName = "db_a8670c_phungthanhtu";
    static String usernameDB = "db_a8670c_phungthanhtu_admin";
    static String passwordDB = "Phungthanhtu!1";
    static String query = "select * from students";


    public static void main(String args[]) throws SQLServerException {
        /*SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(usernameDB);
        ds.setPassword(passwordDB);
        ds.setURL(urlDB);
        ds.setDatabaseName(dbName);

        try(Connection con = ds.getConnection(); Statement stm = con.createStatement();ResultSet resultSet = stm.executeQuery(query))
        {
            System.out.print(con.getMetaData());
            System.out.print("\nConnected Success\n");

            ResultSetMetaData metaData = resultSet.getMetaData();
            // display the column header in the ResultSet
            for ( int i = 1; i <= metaData.getColumnCount(); i++)
            System.out. printf("%-22s\t",metaData.getColumnName(i));
            System.out. println () ;

            while ( resultSet .next()){
            for ( int i = 1; i<=metaData.getColumnCount(); i++){
                System.out. printf ("%-22s\t",resultSet.getObject(i));
                }
             System.out. println () ;

            }
            resultSet . close () ;
            stm. close () ;
            con. close ();

        } catch (SQLException e) {
                e.printStackTrace();
            }*/

        /*StudentDAO a = new StudentDAO();

        a.get("K1999").Print();*/
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while(true)
        {
            MenuView.displayMainMenu();
            try {
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Wrong format, please enter a number");
                continue;
            }
            MenuView.executeMenu(choice,dao);
            if(choice >= 5)
                return;
        }

    }
}
