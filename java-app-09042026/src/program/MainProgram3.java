/*
	====================================
	
	            JDBC
	
	      UPDATE - Static Values
	      
	 (PrepareStatement-Same Query Multiple Times)
	
	====================================
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainProgram3 {
	public static void main(String[] args) {
		
		Connection dbConn = null;
		PreparedStatement dbPreStmt = null;
		
		try {
			// Step 1: Load Driver (optional in newer JDBC versions)
			Class.forName("com.msql.cj.jdbc.Driver");
			
			// Step 2: Create Connection
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049","root","root");
			
			// Step 3: SQL Query
			String sqlQuery ="UPDATE employees_list SET first_name = ? where id = ? ";
			
			// Step 4: Create PreparedStatement
			dbPreStmt = dbConn.prepareStatement(sqlQuery);
			
			// Step 5: Set Values
			dbPreStmt.setString(1,"raamu");
			dbPreStmt.setInt(2,105);
			
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
