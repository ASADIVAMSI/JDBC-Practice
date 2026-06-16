package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram3 {
	public static void main(String[] args) {
		
		Connection dbConn = null;
		Statement dbStmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049","root","root");
			dbStmt = dbConn.createStatement();

			
			String sqlQuery = "UPDATE employee SET firstName = 'Kumar' WHERE empId = 103"; 
			int numRowsAffeted = dbStmt.executeUpdate(sqlQuery);
			
			if(numRowsAffeted != 0) {
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
				if(dbStmt !=null) {
					dbStmt.close();
					
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
