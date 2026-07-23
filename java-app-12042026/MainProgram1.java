/*
====================================

        JDBC CRUD
    Using Statement
    (Static Values)

====================================
*/

package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram1 {

	public static void main(String[] args) {

		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;

		try {
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create Connection
			dbConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jfs_049",
					"root",
					"root");

			// Create Statement
			dbStmt = dbConn.createStatement();

			// ================= INSERT =================
			String insertQuery = "INSERT INTO employees_list(first_name,last_name,email_address,login_password) "
					+ "VALUES('Vamsi','Asadi','vamsi@gmail.com','12345')";

			int insert = dbStmt.executeUpdate(insertQuery);

			if (insert > 0) {
				System.out.println("Record Inserted Successfully.");
			}

			// ================= SELECT =================
			String selectQuery = "SELECT * FROM employees_list WHERE email_address='vamsi@gmail.com'";

			dbRs = dbStmt.executeQuery(selectQuery);

			if (dbRs.next()) {
				System.out.println("\nEmployee Details");
				System.out.println("----------------------------");
				System.out.println("ID        : " + dbRs.getInt(1));
				System.out.println("First Name: " + dbRs.getString(2));
				System.out.println("Last Name : " + dbRs.getString(3));
				System.out.println("Email     : " + dbRs.getString(4));
				System.out.println("Password  : " + dbRs.getString(5));
			}

			dbRs.close();

			// ================= UPDATE =================
			String updateQuery = "UPDATE employees_list "
					+ "SET login_password='99999' "
					+ "WHERE email_address='vamsi@gmail.com'";

			int update = dbStmt.executeUpdate(updateQuery);

			if (update > 0) {
				System.out.println("\nRecord Updated Successfully.");
			}

			// ================= DELETE =================
			String deleteQuery = "DELETE FROM employees_list "
					+ "WHERE email_address='vamsi@gmail.com'";

			int delete = dbStmt.executeUpdate(deleteQuery);

			if (delete > 0) {
				System.out.println("Record Deleted Successfully.");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbRs != null)
					dbRs.close();

				if (dbStmt != null)
					dbStmt.close();

				if (dbConn != null)
					dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
