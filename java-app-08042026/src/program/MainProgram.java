package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram {
	public static void main(String[] args) {
		
		Connection dbConn;
		Statement dbStmt;
		
		try {
			// Step 1: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DATABASE DRIVER FOUND & LOADED.");
			
			//Step 2: Establish Connection
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049", "root", "root");
			System.out.println("CONNECTION ESTABLISHED WITH THE DATABASE SERVER.");
			
			//Step 3: Create Statement
			dbStmt = dbConn.createStatement();
			
			//Step 4: Write SQL Query
			String sqlQuery ="""
					
					CREATE TABLE employees_list (
						emp_id INT PRIMARY KEY AUTO_INCREMENT,
						first_name CHAR(10),
						last_name CHAR(10),
						email_address CHAR(15),
						login_password CHAR(15)
						);
						
						""";
			
			//Step 5: Execute Query
			dbStmt.executeUpdate(sqlQuery);
			
			System.out.println("TABLE CREATED SUCCESSFULLY.");
			
			//Step 6: Close Resource
			dbConn.close();
			dbStmt.close();
					

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

}
