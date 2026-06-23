package program;
import java.sql.*;
import java.util.*;
public class MainProgram2 {
	public static void main(String[] args) {
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049", "root", "root");
			dbStmt = dbConn.createStatement();
			
			String sqlQuery = "SELECT *FROM students";
			
			dbRs = dbStmt.executeQuery(sqlQuery);
			boolean flag = false;
			
			System.out.println("StuId|FirstName|LastName |");
			System.out.println("-------------------------");
			while(dbRs.next()) {
				flag = true;
				System.out.println(dbRs.getInt(1)+"\t"+dbRs.getString(2)+"\t"+dbRs.getString(3));
			}
			if(flag=false) {
				System.out.println("No Record Found.");
			}
			
		}catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
	}

}
