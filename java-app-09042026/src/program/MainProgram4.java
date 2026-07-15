/*
	====================================
	
	            JDBC
	
	      UPDATE - Dynamic Values
	      
	 (PrepareStatement-Same Query Multiple Times)
	
	====================================
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MainProgram4 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		Connection dbConn = null;
		PreparedStatement dbPreStmt = null;
		
		try {
			// Step 1: Load Driver (optional in newer JDBC versions)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2: Create Connection
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049","root","root");
			
			// Step 3: SQL Query
			String sqlQuery ="UPDATE employees_list SET first_name = ? where id = ? ";
			
			// Step 4: Create PreparedStatement
			dbPreStmt = dbConn.prepareStatement(sqlQuery);
			
			//Dynamic Values
			System.out.print("Enter First Name: ");
			String firstName = scn.nextLine();
			 
			System.out.print("Enter EmployeeID: ");
			int EmployeeID = scn.nextInt();
			 
			 
			
			// Step 5: Set Values
			dbPreStmt.setString(1,firstName);
			dbPreStmt.setInt(2,EmployeeID);
			
			int noOfRowsAff = dbPreStmt.executeUpdate();
			
			if(noOfRowsAff != 0) {
				System.out.println("Record Updated.");
			}else {
				System.out.println("Not Updated.");
			}
			
			
		}catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
		}finally {
			
			try {
				if(dbPreStmt !=null) {
					dbPreStmt.close();
					
				}
				if(dbConn !=null) {
					dbConn.close();
					
				}
				
			}catch(SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}		
	}
}
