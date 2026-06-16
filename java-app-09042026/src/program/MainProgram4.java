package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram4 {
	public static void main(String[] args) {
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049","root","root");
			dbStmt = dbConn.createStatement();

			String sqlQuery1 = "INSERT INTO employee VALUES (105,'Ram','Krishna')"; 
			dbStmt.executeUpdate(sqlQuery1);
			
			String sqlQuery2 = "UPDATE employee SET firstName = 'Kumar' WHERE empId = 103"; 
			dbStmt.executeUpdate(sqlQuery2);
			
			String sqlQuery3 = "DELETE FROM employee WHERE empId = 103"; 
			dbStmt.executeUpdate(sqlQuery3);
			
			String sqlQuery4 = "SELECT * FROM employee"; 
			dbRs=dbStmt.executeQuery(sqlQuery4);
			
			while(dbRs.next()) {
				
					int empId = dbRs.getInt(1);
					String firstName = dbRs.getString(2);
					String lastName  = dbRs.getString(3);
					
					System.out.println("Employee Id: "+empId);
					System.out.println("First Name : "+firstName);
					System.out.println("Last Name : "+lastName);
					System.out.println();
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
