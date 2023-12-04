package controller;

import model.User;
import service.SignupService;

/**
 * The SignupController class is responsible for handling user signup operations.
 * It facilitates the communication between the user interface and the service layer
 * to create a new user account and store the user information in the database.
 */
public class SignupController {
	
	/**
     * Attempts to sign up a new user with the provided information.
     *
     * @param fullName  The full name of the user.
     * @param email     The email address of the user.
     * @param gameName  The game name chosen by the user.
     * @param password  The password chosen by the user.
     * @return True if the signup process is successful, false otherwise.
     */
	public static boolean signUpUser(String fullName,  String email,String gameName, String password) {
        try {
        	// Create a new User object with the provided information
            User newUser = new User(fullName, email, gameName, password);
            
            // Initialize the SignupService with the new user
            SignupService signupService = new SignupService(newUser);
            
            // Save the user information to the database
            signupService.saveSignInToDataBase();
            
            // Signup successful
            return true;
            
        } catch (Exception ex) {
        	
        	// Print the exception details for debugging
            ex.printStackTrace();
            
            // Signup failed
            return false;
        }
    }

}
