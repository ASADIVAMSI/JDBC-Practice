/*
====================================

            JDBC

   INSERTION-Dynamic Values

====================================
*/
package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainProgram2 {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try{
			Connection dbConn = null;
			Statement dbStmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049","root","root");
			dbStmt = dbConn.createStatement();
			
			 System.out.print("Enter ID: ");
			 int empId = scn.nextInt();
			 scn.nextLine();
			 
			 System.out.print("Enter First Name: ");
			 String firstName = scn.nextLine();
			 
			 System.out.print("Enter Last Name: ");
			 String lastName = scn.nextLine();
			 
			 System.out.print("Enter Email: ");
			 String email = scn.nextLine();
			 
			 System.out.print("Enter Password: ");
			 String password = scn.nextLine();
			 
			 String sqlQuery = "INSERT INTO employees_list VALUES(" + empId + ",'" + firstName + "','" + lastName + "','" + email + "','" + password + "')";
			 
			 int noOfRowsAff = dbStmt.executeUpdate(sqlQuery);
			 
			 if(noOfRowsAff > 0) {
				 System.out.println("Data Inserted Successfully.");
			 }
			
		} catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
	}

}

//The Above Program is not Recommended.One Operation Multiple time should use PreStmt 

/*
 	Note:--
	This works with Statement, but do not use this approach in real applications because it is vulnerable to SQL Injection. 
	For user input, PreparedStatement is the recommended and secure approach.
 
 		1)Stmt:-   if you want to execute multiple Sql Query highly Recommended                                       
 		====  	
 		
	 		Adv:
	 		1)use same stmt object to execute Multiple type of sql Querys
	 		
	 		
	 		
	 					ex:-   dbStmt.executeUpdate("insert Query "); 
	 					       dbStmt.executeUpdate("update Query ");
	 					       dbStmt.executeUpdate("delete Query ");
	 					       dbStmt.executeQuery("select Query ");
	 		
	 		
	 		Disadv:
	 			If you want to execute same Query multiple time Every Time Code will Compile And Executed That's why
	 			we Using preparedStmt.
	 			Performance is down
 		
 		
 		2)PreStmt:- If want to execute same Query Multiple time 
 					
 		
	 		Adv:
	 			If want to execute same Query Multiple time 
 					At the Time of creating preparedStmt we Send SqlQuery
 					we we executed Query multiple Time the Query will Complie Ones
 					Performance will be Improved
	 		
	 		Disadv:
	 			It will work only one Sql Query
 		
 		
 		CallableStmt:
 		=============
 		
 		
 
 */
