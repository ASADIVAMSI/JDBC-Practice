package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainProgram2 {
	public static void main(String[] args) {
		
		Connection dbConn = null;
		Statement dbStmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049","root","root");
			dbStmt = dbConn.createStatement();

			
			String sqlQuery = "UPDATE employee SET firstName = 'Kumar' WHERE empId = 103"; 
			int numRowsAffeted = dbStmt.executeUpdate(sqlQuery);
			
			if(numRowsAffeted != 0) {
				System.out.println("Record Updated.");
			}else {
				System.out.println("Not Updated.");
			}
			
			String sqlQuery1 = "UPDATE employee SET firstName = 'ravi' WHERE empId = 104"; 
			int numRowsAffeted1 = dbStmt.executeUpdate(sqlQuery1);
			
			
			if(numRowsAffeted1 != 0) {
				System.out.println("Record Updated.");
			}else {
				System.out.println("Not Updated.");
			}
			
			
		}catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
		}finally {
			
			try {
				if(dbStmt !=null) {
					dbStmt.close();
					
				}
				if(dbConn !=null) {
					dbConn.close();
					
				}
				
			}catch(SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}

}


/*


Connection dbConn = null;
PreparedStatement dbPs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    dbConn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/jfs_049",
        "root",
        "root"
    );

    String sqlQuery1 = "INSERT INTO employee VALUES (?, ?, ?)";

    dbPs = dbConn.prepareStatement(sqlQuery1);

    dbPs.setInt(1, 105);
    dbPs.setString(2, "Ram");
    dbPs.setString(3, "Krishna");

    int result = dbPs.executeUpdate();

    System.out.println(result + " record inserted");

} catch (Exception e) {
    e.printStackTrace();
}

*/