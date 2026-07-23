/*
====================================

            JDBC CRUD
            
          Dynamic Values 
          
         Using Statement

====================================
*/

package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainProgram1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Connection dbConn = null;
        Statement dbStmt = null;
        ResultSet dbRs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            dbConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jfs_049",
                    "root",
                    "root");

            dbStmt = dbConn.createStatement();

            while (true) {

                System.out.println("\n========= JDBC CRUD =========");
                System.out.println("1. Insert");
                System.out.println("2. Select");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                // INSERT
                case 1:

                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    String insertQuery =
                            "INSERT INTO employees_list(first_name,last_name,email_address,login_password) VALUES('"
                                    + firstName + "','"
                                    + lastName + "','"
                                    + email + "','"
                                    + password + "')";

                    int insert = dbStmt.executeUpdate(insertQuery);

                    if (insert > 0)
                        System.out.println("Record Inserted Successfully.");
                    else
                        System.out.println("Insert Failed.");

                    break;

                // SELECT
                case 2:

                    System.out.print("Enter Email: ");
                    email = sc.nextLine();

                    String selectQuery =
                            "SELECT * FROM employees_list WHERE email_address='" + email + "'";

                    dbRs = dbStmt.executeQuery(selectQuery);

                    if (dbRs.next()) {

                        System.out.println("\nEmployee Details");
                        System.out.println("---------------------------");
                        System.out.println("ID       : " + dbRs.getInt(1));
                        System.out.println("First    : " + dbRs.getString(2));
                        System.out.println("Last     : " + dbRs.getString(3));
                        System.out.println("Email    : " + dbRs.getString(4));
                        System.out.println("Password : " + dbRs.getString(5));

                    } else {
                        System.out.println("Record Not Found.");
                    }

                    if (dbRs != null)
                        dbRs.close();

                    break;

                // UPDATE
                case 3:

                    System.out.print("Enter Email: ");
                    email = sc.nextLine();

                    System.out.print("New Password: ");
                    password = sc.nextLine();

                    String updateQuery =
                            "UPDATE employees_list SET login_password='"
                                    + password
                                    + "' WHERE email_address='"
                                    + email + "'";

                    int update = dbStmt.executeUpdate(updateQuery);

                    if (update > 0)
                        System.out.println("Record Updated Successfully.");
                    else
                        System.out.println("Record Not Found.");

                    break;

                // DELETE
                case 4:

                    System.out.print("Enter Email: ");
                    email = sc.nextLine();

                    String deleteQuery =
                            "DELETE FROM employees_list WHERE email_address='"
                                    + email + "'";

                    int delete = dbStmt.executeUpdate(deleteQuery);

                    if (delete > 0)
                        System.out.println("Record Deleted Successfully.");
                    else
                        System.out.println("Record Not Found.");

                    break;

                // EXIT
                case 5:

                    System.out.println("Thank You!");
                    sc.close();

                    if (dbStmt != null)
                        dbStmt.close();

                    if (dbConn != null)
                        dbConn.close();

                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
