/*
====================================

        JDBC CRUD
Using PreparedStatement (Static Values)

====================================
*/

package program;

import java.sql.*;

public class MainProgram2 {

	public static void main(String[] args) {

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

			// ================= INSERT =================
			String insertQuery = "INSERT INTO employees_list(first_name,last_name,email_address,login_password) VALUES(?,?,?,?)";

			dbPstmt = dbConn.prepareStatement(insertQuery);

			dbPstmt.setString(1, "Vamsi");
			dbPstmt.setString(2, "Asadi");
			dbPstmt.setString(3, "vamsi@gmail.com");
			dbPstmt.setString(4, "12345");

			int insert = dbPstmt.executeUpdate();

			if (insert > 0)
				System.out.println("Record Inserted Successfully.");

			dbPstmt.close();

			// ================= SELECT =================
			String selectQuery = "SELECT * FROM employees_list WHERE email_address=?";

			dbPstmt = dbConn.prepareStatement(selectQuery);

			dbPstmt.setString(1, "vamsi@gmail.com");

			dbRs = dbPstmt.executeQuery();

			if (dbRs.next()) {
				System.out.println("\nEmployee Details");
				System.out.println("--------------------------");
				System.out.println("ID        : " + dbRs.getInt(1));
				System.out.println("First Name: " + dbRs.getString(2));
				System.out.println("Last Name : " + dbRs.getString(3));
				System.out.println("Email     : " + dbRs.getString(4));
				System.out.println("Password  : " + dbRs.getString(5));
			}

			dbRs.close();
			dbPstmt.close();

			// ================= UPDATE =================
			String updateQuery = "UPDATE employees_list SET login_password=? WHERE email_address=?";

			dbPstmt = dbConn.prepareStatement(updateQuery);

			dbPstmt.setString(1, "99999");
			dbPstmt.setString(2, "vamsi@gmail.com");

			int update = dbPstmt.executeUpdate();

			if (update > 0)
				System.out.println("\nRecord Updated Successfully.");

			dbPstmt.close();

			// ================= DELETE =================
			String deleteQuery = "DELETE FROM employees_list WHERE email_address=?";

			dbPstmt = dbConn.prepareStatement(deleteQuery);

			dbPstmt.setString(1, "vamsi@gmail.com");

			int delete = dbPstmt.executeUpdate();

			if (delete > 0)
				System.out.println("Record Deleted Successfully.");

			dbPstmt.close();
			dbConn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
