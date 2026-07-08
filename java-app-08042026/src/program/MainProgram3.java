/*
====================================

            JDBC

   INSERTION-Dynamic Values
   (Using PreparedStatement Recommended)

====================================
*/
package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MainProgram4 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		Connection dbConn = null;
		PreparedStatement dbPreStmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049","root","root");
			
			System.out.print("Enter Employee ID: ");
			int empID = scn.nextInt();
			scn.nextLine();
			
			System.out.print("Enter FirstName: ");
			String firstName = scn.nextLine();
			
			System.out.print("Enter LastName: ");
			String lastName = scn.nextLine();
			
			System.out.print("Enter Email: ");
			String emailAddress = scn.nextLine();
			
			System.out.print("Enter Password: ");
			String Password = scn.nextLine();
			
			String sqlQuery = "INSERT INTO employees_list VALUES(?,?,?,?,?)";
			
			dbPreStmt = dbConn.prepareStatement(sqlQuery);
			
			dbPreStmt.setInt(1, empID);
			dbPreStmt.setString(2, firstName);
			dbPreStmt.setString(3, lastName);
			dbPreStmt.setString(4, emailAddress);
			dbPreStmt.setString(5, Password);
			
			int noOfRowsAff = dbPreStmt.executeUpdate();
			
			if(noOfRowsAff > 0) {
				System.out.println("Data Inserted Successfully.");
			}else {
				System.out.println("Insertion Faild.");
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		
		scn.close();
	}

}
