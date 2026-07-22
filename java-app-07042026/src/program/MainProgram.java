/*
====================================

		      JDBC
			CREATION

====================================
*/


package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainProgram {

    public static void main(String[] args) {

        try {

            // Step 1: Load the MySQL JDBC Driver into JVM memory.
            // Class.forName() searches for the driver class and loads it.
            // Without the driver, Java cannot communicate with MySQL.
			
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DATABASE DRIVER FOUND & LOADED.");

            // Step 2: Create a connection with the MySQL Server.
            // DriverManager uses the loaded driver to establish the connection.

            // URL  : jdbc:mysql://localhost:3306
            // localhost -> MySQL is running on this computer.
            // 3306      -> Default MySQL port number.
        
            // "root" -> Username
            // "root" -> Password
			
            Connection dbConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306",
                    "root",
                    "root");

            System.out.println("CONNECTION ESTABLISHED WITH THE DATABASE SERVER.");

            // Step 3: Close the connection.
            // Always close the connection after completing database operations.
			
            dbConn.close();
            System.out.println("CONNECTION CLOSED.");

        } catch (ClassNotFoundException cnfEx) {
            // Executed if the JDBC Driver class is not found.
            cnfEx.printStackTrace();

        } catch (SQLException sqlEx) {
            // Executed if any database-related error occurs.
            sqlEx.printStackTrace();
        }
    }
}
