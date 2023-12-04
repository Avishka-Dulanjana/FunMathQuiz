package controller;

import model.User;
import service.SignupService;

public class SignupController {
	public static boolean signUpUser(String fullName,  String email,String gameName, String password) {
        try {
            User newUser = new User(fullName, email, gameName, password);
            SignupService signupService = new SignupService(newUser);
            signupService.saveSignInToDataBase();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
