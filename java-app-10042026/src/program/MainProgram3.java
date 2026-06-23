package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainProgram3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Email Address: ");
		String emailAddress = scanner.nextLine();
		System.out.print("Enter Password: ");
		String loginPassword = scanner.next();
		
		Connection dbConn = null;
		PreparedStatement dbStmt = null;
		ResultSet dbRs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049", "root", "root");
			
			String sqlQuery = "SELECT * FROM employee_personal WHERE email_address=? AND login_password=?";
			dbStmt = dbConn.prepareStatement(sqlQuery);

			dbStmt.setString(1, emailAddress);
			dbStmt.setString(2, loginPassword);
			dbRs = dbStmt.executeQuery();
			if (dbRs.next()) {
				System.out.println("Welcome " + dbRs.getString(2) + " " + dbRs.getString(3));
			} else {
				System.out.println("Invalid Access.");
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbRs != null) {
					dbRs.close();
				}
				
				if (dbStmt != null) {
					dbStmt.close();
				}
				
				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		scanner.close();
	}
}