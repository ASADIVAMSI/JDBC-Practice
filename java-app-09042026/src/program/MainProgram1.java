/*
====================================

            JDBC

           UPDATE

====================================
*/


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
			
			String sqlQuery ="UPDATE employees_list SET login_password ='123'WHERE emp_id =103";
			
			int numRowsAffeted = dbStmt.executeUpdate(sqlQuery);
			
			if(numRowsAffeted != 0) {
				System.out.println("Record Updated");
			}else {
				System.out.println("Record Not updated");
			}
			
			
		}catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}finally {    //Adding Finally block 
			
			try {
				if(dbConn != null) {
					dbConn.close();
				}
				if(dbStmt != null) {
					dbStmt.close();
				}
			}catch(SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		
	}
}
