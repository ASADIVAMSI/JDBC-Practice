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
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049","root","root");
			dbStmt = dbConn.createStatement();
			
/* we know that result set have only one record that's why no need to write condtion here*/
//			String sqlQuery = "SELECT * FROM employee WHERE empId = 104";
//			dbRs  = dbStmt.executeQuery(sqlQuery);
//			
//			    dbRs.next();
//				int empId = dbRs.getInt(1);
//				String firstName = dbRs.getString(2);
//				String lastName  = dbRs.getString(3);
//				
//				System.out.println("Employee Id: "+empId);
//				System.out.println("First Name : "+firstName);
//				System.out.println("Last Name : "+lastName);
//				System.out.println();
			
			

//				String sqlQuery = "SELECT * FROM employee";
//				dbRs  = dbStmt.executeQuery(sqlQuery);
				
//			while(dbRs.next()) {
//			
//				int empId = dbRs.getInt(1);
//				String firstName = dbRs.getString(2);
//				String lastName  = dbRs.getString(3);
//				
//				System.out.println("Employee Id: "+empId);
//				System.out.println("First Name : "+firstName);
//				System.out.println("Last Name : "+lastName);
//				System.out.println();
//			}
				
			
//			
//				String sqlQuery = "SELECT * FROM employee WHERE empId = 109";
//				dbRs  = dbStmt.executeQuery(sqlQuery);
//				
//				if(dbRs.next()) {
//					System.out.println("Employee found given Id.");
//					int empId = dbRs.getInt(1);
//					String firstName = dbRs.getString(2);
//					String lastName  = dbRs.getString(3);
//					
//					System.out.println("Employee Id: "+empId);
//					System.out.println("First Name : "+firstName);
//					System.out.println("Last Name : "+lastName);
//					System.out.println();
//				}else {
//					System.out.println("Employee not found given Id.");
//				}
				
			
			
			
		}catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
		}finally {
			
			try {
				if(dbRs !=null) {
					dbRs.close();
					
				}
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
