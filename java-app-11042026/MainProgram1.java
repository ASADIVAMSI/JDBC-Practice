/*
====================================

            JDBC

           DELETE

====================================
*/

package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram1 {
	public static void main(String[] args) {

		Connection dbConn = null;
		Statement dbStmt = null;

		try {
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create Connection
			dbConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jfs_049",
					"root",
					"root");

			// Create Statement
			dbStmt = dbConn.createStatement();

			// SQL DELETE Query
			String sqlQuery = "DELETE FROM employees_list WHERE email_address='vamsi@gmail.com'";

			// Execute Query
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
	}
}
