/*
	====================================
	
	            JDBC
	
	           DELETE
	      
	 		    Using Statement
	
	====================================
*/
package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainProgram2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Email Address to Delete: ");
		String emailAddress = scanner.nextLine();

		Connection dbConn = null;
		Statement dbStmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jfs_049",
					"root",
					"root");

			dbStmt = dbConn.createStatement();

			String sqlQuery = "DELETE FROM employees_list WHERE email_address='" + emailAddress + "'";

			// Display Query
			System.out.println(sqlQuery);

			int rows = dbStmt.executeUpdate(sqlQuery);

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
				if (dbStmt != null) {
					dbStmt.close();
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
