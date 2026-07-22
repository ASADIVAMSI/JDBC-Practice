/*
====================================

            JDBC
 
          INSERTION

====================================
*/

package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram1 {

    public static void main(String[] args) {

        // Reference variable to store database connection
        Connection dbConn = null;

        // Reference variable to execute SQL queries
        Statement dbStmt = null;

        try {

            // Step 1: Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully.");

            // Step 2: Establish connection with MySQL database
            dbConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jfs_049",
                    "root",
                    "root");

            System.out.println("Database Connected Successfully.");

            // Step 3: Create Statement object
            // Statement is used to execute SQL queries
            dbStmt = dbConn.createStatement();

            // Step 4: Write SQL INSERT query
            String sqlQuery =
                    "INSERT INTO employees VALUES (101,'ASADI','VAMSI','vamsi@gmail.com','123')";

            // Step 5: Execute INSERT query
            // executeUpdate() is used for
            // INSERT, UPDATE, DELETE and CREATE
            int rows = dbStmt.executeUpdate(sqlQuery);

            // Step 6: Check whether data was inserted
            if (rows > 0) {
                System.out.println("Data Inserted Successfully.");
            } else {
                System.out.println("Data Not Inserted.");
            }

            // Step 7: Close Statement
            dbStmt.close();

            // Step 8: Close Database Connection
            dbConn.close();

            System.out.println("Resources Closed.");

        } catch (ClassNotFoundException cnfEx) {

            // Executes if JDBC Driver is not found
            cnfEx.printStackTrace();

        } catch (SQLException sqlEx) {

            // Executes if any SQL-related error occurs
            sqlEx.printStackTrace();
        }
    }
}
