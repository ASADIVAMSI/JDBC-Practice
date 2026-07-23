/*
====================================

            JDBC

           SELECT

====================================
*/

package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainProgram1 {
	public static void main(String[] args) {
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null; //RS Using SELECT Stmt

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049", "root", "root");
			dbStmt = dbConn.createStatement();

			String sqlQuery = "SELECT * FROM employees_list WHERE email_address='vamsi@gmail.com' AND login_password='123'";
			
			dbRs = dbStmt.executeQuery(sqlQuery);
			
			if (dbRs.next()) {
				System.out.println("Welcome " + dbRs.getString(2) + " " + dbRs.getString(3));
			} else {
				System.out.println("Invalid Access.");
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbRs != null) {
					dbRs.close();
				}
				
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
