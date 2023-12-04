package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import repo.DatabaseConnection;
import model.User;

public class LoginService {
	
		public static User authenticateUser(String email, String password) {
		
		try {
            Connection con = DatabaseConnection.createConnection();
            Statement stm = con.createStatement();
            String sql = "select * from signup1 where user_email='" + email + "' and user_password='" + password + "';";
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String userEmail = rs.getString("user_email");
                String userPassword = rs.getString("user_password");
                String userGame = rs.getString("user_game_name");
                // You can add more fields as needed
                return new User(userEmail, userPassword, userGame);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}


