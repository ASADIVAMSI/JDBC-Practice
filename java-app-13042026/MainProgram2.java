/*
====================================
  
            JDBC CRUD
          
          Dynamic Values
          
     Using PreparedStatement

====================================
*/

package program;

import java.sql.*;
import java.util.Scanner;

public class MainProgram2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Connection dbConn = null;
		PreparedStatement dbPstmt = null;
		ResultSet dbRs = null;

		try {
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create Connection
			dbConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jfs_049",
					"root",
					"root");

			while (true) {

				System.out.println("\n========= JDBC CRUD =========");
				System.out.println("1. Insert");
				System.out.println("2. Select");
				System.out.println("3. Update");
				System.out.println("4. Delete");
				System.out.println("5. Exit");
				System.out.print("Enter Your Choice: ");

				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {

				// INSERT
				case 1:

					System.out.print("First Name: ");
					String firstName = sc.nextLine();

					System.out.print("Last Name: ");
					String lastName = sc.nextLine();

					System.out.print("Email Address: ");
					String email = sc.nextLine();

					System.out.print("Password: ");
					String password = sc.nextLine();

					String insertQuery = "INSERT INTO employees_list(first_name,last_name,email_address,login_password) VALUES(?,?,?,?)";

					dbPstmt = dbConn.prepareStatement(insertQuery);

					dbPstmt.setString(1, firstName);
					dbPstmt.setString(2, lastName);
					dbPstmt.setString(3, email);
					dbPstmt.setString(4, password);

					int insert = dbPstmt.executeUpdate();

					if (insert > 0)
						System.out.println("Record Inserted Successfully.");
					else
						System.out.println("Insertion Failed.");

					dbPstmt.close();
					break;

				// SELECT
				case 2:

					System.out.print("Enter Email Address: ");
					email = sc.nextLine();

					String selectQuery = "SELECT * FROM employees_list WHERE email_address=?";

					dbPstmt = dbConn.prepareStatement(selectQuery);
					dbPstmt.setString(1, email);

					dbRs = dbPstmt.executeQuery();

					if (dbRs.next()) {
						System.out.println("\nEmployee Details");
						System.out.println("--------------------------");
						System.out.println("ID        : " + dbRs.getInt(1));
						System.out.println("First Name: " + dbRs.getString(2));
						System.out.println("Last Name : " + dbRs.getString(3));
						System.out.println("Email     : " + dbRs.getString(4));
						System.out.println("Password  : " + dbRs.getString(5));
					} else {
						System.out.println("Record Not Found.");
					}

					dbRs.close();
					dbPstmt.close();
					break;

				// UPDATE
				case 3:

					System.out.print("Enter Email Address: ");
					email = sc.nextLine();

					System.out.print("Enter New Password: ");
					password = sc.nextLine();

					String updateQuery = "UPDATE employees_list SET login_password=? WHERE email_address=?";

					dbPstmt = dbConn.prepareStatement(updateQuery);

					dbPstmt.setString(1, password);
					dbPstmt.setString(2, email);

					int update = dbPstmt.executeUpdate();

					if (update > 0)
						System.out.println("Record Updated Successfully.");
					else
						System.out.println("Record Not Found.");

					dbPstmt.close();
					break;

				// DELETE
				case 4:

					System.out.print("Enter Email Address: ");
					email = sc.nextLine();

					String deleteQuery = "DELETE FROM employees_list WHERE email_address=?";

					dbPstmt = dbConn.prepareStatement(deleteQuery);

					dbPstmt.setString(1, email);

					int delete = dbPstmt.executeUpdate();

					if (delete > 0)
						System.out.println("Record Deleted Successfully.");
					else
						System.out.println("Record Not Found.");

					dbPstmt.close();
					break;

				// EXIT
				case 5:

					System.out.println("Thank You!");

					sc.close();

					if (dbConn != null)
						dbConn.close();

					System.exit(0);

				default:
					System.out.println("Invalid Choice.");
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
