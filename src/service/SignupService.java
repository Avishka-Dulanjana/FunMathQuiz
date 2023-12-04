package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import repo.DatabaseConnection;
import model.User;

/**
 * The SignupService class manages user signup operations.
 * It includes methods to save user registration details to the database.
 */
public class SignupService {
	// Instance variable to store user registration details
	User sign;
	
	 /**
     * Constructor for SignupService.
     * @param sSignUp The User object containing signup details.
     */
	public SignupService(User sSignUp)
		{
			this.sign=sSignUp;
		}
	
	 /**
     * Saves user signup details to the database.
     */
		public void saveSignInToDataBase()
			{ // method for add the user registration details to the Database
				try{
					Connection con=DatabaseConnection.createConnection();
					// SQL query for inserting user details into the 'signup' table
					String sql="INSERT INTO signup(user_name,user_game_name,user_email, user_password)"+"VALUES('"+sign.user_name+"','"+sign.user_email+"','"+sign.user_game_name+"','"+sign.user_password+"')"; 
					PreparedStatement statement=con.prepareStatement(sql);
					statement.executeUpdate();
					con.close(); 
               
				}catch(Exception e){
					System.out.println("Error"+e.getLocalizedMessage());
           
				}
			}  
}