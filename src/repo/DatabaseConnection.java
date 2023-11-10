package repo;
import java.sql.*;
import java.sql.DriverManager;


public class DatabaseConnection {
	
	
	public static Connection createConnection() throws Exception{
		
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzlegame?useSSL=false","root","1234");
		     return con;		 
	}
}
 // Database connection class
