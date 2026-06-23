package program;
import java.sql.*;
public class MainProgram {
	public static void main(String[] args) {
		
		Connection dbConn = null;
		Statement  dbStmt = null;
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049", "root", "root");
			dbStmt=dbConn.createStatement();
			String sqlQuery = "CREATE TABLE students(student_Id int,firstname varchar(50),lastname varchar(50))";
			
			dbStmt.executeUpdate(sqlQuery);
			System.out.println("Table created Successfully.");
		
		}catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}catch(SQLException sqlEx) {
			   sqlEx.printStackTrace();
		}
	}

}
