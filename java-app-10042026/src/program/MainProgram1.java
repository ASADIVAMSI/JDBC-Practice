package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainProgram1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int x = 10;
		int y = 20;
		System.out.println(x);//10
		System.out.println("x");//x
		System.out.println("x=" + x);//x=10
		System.out.println("x=" + x + ";");//x=10;
		System.out.println("x=" + x + ", y = " + y);//x=10, y=20

		System.out.print("Enter Employee ID: ");
		int employeeId = scanner.nextInt();
		System.out.print("Enter First Name: ");
		String firstName = scanner.next();
		System.out.print("Enter Last Name: ");
		String lastName = scanner.next();
		System.out.print("Enter Date of Birth: ");
		String dateOfBirth = scanner.next();

		Connection dbConn = null;
		Statement dbStmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049", "root", "root");
			dbStmt = dbConn.createStatement();

			//String sqlQuery = "INSERT INTO employee_personal VALUES(employeeId, 'firstName', 'lastName', 'dateOfBirth')";
			String sqlQuery = "INSERT INTO employee_personal VALUES("+employeeId+", '"+firstName+"', '"+lastName+"', '"+dateOfBirth+"')";
			System.out.println(sqlQuery);
			
			int numOfRowsAffected = dbStmt.executeUpdate(sqlQuery);
			if (numOfRowsAffected != 0) {
				System.out.println("Employee record successfully saved.");
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
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