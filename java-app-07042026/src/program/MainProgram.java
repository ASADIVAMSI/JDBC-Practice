package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainProgram {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DATABASE DRIVER FOUND & LOADED.");
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			System.out.println("CONNECTION ESTABLISHED WITH THE DATABASE SERVER.");

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

}
