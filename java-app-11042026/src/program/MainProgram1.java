package program;
import java.sql.*;
import java.util.Scanner;

public class MainProgram1 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter Student Id:");
		int studentId = scn.nextInt();
		System.out.print("Enter FirstName :");
		String firstName = scn.next();
		System.out.print("Enter LastName :");
		String lastName = scn.next();
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049", "root", "root");
			dbStmt = dbConn.createStatement();
			
			//String sqlQuery = "INSERT INTO students values("+studentId+",'"+firstName+"','"+lastName+"')";
			
			String sqlQuery = String.format("INSERT INTO students values (%d,'%s','s')",studentId,firstName,lastName);
			dbStmt.executeUpdate(sqlQuery);
			System.out.println("sqlQuery Inserted Successfully.");
			
		}catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

}
