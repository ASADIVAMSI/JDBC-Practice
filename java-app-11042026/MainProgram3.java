/*
	====================================
	
	            JDBC
	
	           DELETE
	      
	 	  Using PreparedStatement
	
	====================================
*/

package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MainProgram3 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Email Address to Delete: ");
		String emailAddress = scanner.nextLine();

		Connection dbConn = null;
		PreparedStatement dbPstmt = null;

		try {
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create Connection
			dbConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jfs_049",
					"root",
					"root");

			// SQL Query
			String sqlQuery = "DELETE FROM employees_list WHERE email_address = ?";

			// Create PreparedStatement
			dbPstmt = dbConn.prepareStatement(sqlQuery);

			// Set Parameter
			dbPstmt.setString(1, emailAddress);

			// Execute Query
			int rows = dbPstmt.executeUpdate();

			if (rows > 0) {
				System.out.println("Record Deleted Successfully.");
			} else {
				System.out.println("No Record Found.");
			}

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbPstmt != null) {
					dbPstmt.close();
				}

				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		scanner.close();
	}
}
