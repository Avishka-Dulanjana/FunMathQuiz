package repo;
import java.sql.*;
import java.sql.DriverManager;

/**
 * Utility class for establishing a connection to the MySQL database.
 */

public class DatabaseConnection {
	
	/**
     * Creates a connection to the MySQL database.
     *
     * @return Connection object representing the database connection.
     * @throws SQLException if a database access error occurs.
     * @throws ClassNotFoundException if the MySQL JDBC driver is not found.
     */
	public static Connection createConnection() throws Exception{
			// Load the MySQL JDBC driver
			 Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			 Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzlegame?useSSL=false","root","1234");
		     return connection;		 
	}
}
