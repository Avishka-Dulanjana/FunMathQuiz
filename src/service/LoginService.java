package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import repo.DatabaseConnection;
import model.User;

/**
 * The LoginService class provides functionality for authenticating user credentials.
 */
public class LoginService {
	
	/**
     * Authenticates a user based on the provided email and password.
     *
     * @param email    The user's email address.
     * @param password The user's password.
     * @return A User object if authentication is successful, otherwise null.
     */
	public static User authenticateUser(String email, String password) {
		
		try {
            Connection con = DatabaseConnection.createConnection();
            Statement stm = con.createStatement();
            String sql = "select * from signup1 where user_email='" + email + "' and user_password='" + password + "';";
            ResultSet rs = stm.executeQuery(sql);

            // Check if a user with the provided credentials exists
            if (rs.next()) {
            	// Retrieve user details from the result set
                String userEmail = rs.getString("user_email");
                String userPassword = rs.getString("user_password");
                String userGame = rs.getString("user_game_name");
             // Return a User object representing the authenticated user
                return new User(userEmail, userPassword, userGame);
            }
        } catch (Exception e) {
        	
            System.out.println(e.getMessage());
        }
		
		// Return null if authentication fails
        return null;
    }

}


