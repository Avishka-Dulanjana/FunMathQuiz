package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import repo.DatabaseConnection;
import model.User;

public class SignupService {
	User sign;
public SignupService(User sSignUp)
{
    this.sign=sSignUp;
}
public void saveSignInToDataBase()
{ // method for add the user registration details to the Database
    try{
        Connection con=DatabaseConnection.createConnection();
        String sql="INSERT INTO signup(user_name,user_game_name,user_email, user_password)"+"VALUES('"+sign.user_name+"','"+sign.user_email+"','"+sign.user_game_name+"','"+sign.user_password+"')"; 
        PreparedStatement statement=con.prepareStatement(sql);
        statement.executeUpdate();
        con.close(); 
               
    } 
    catch(Exception e){
           System.out.println("Error"+e.getLocalizedMessage());
           
    }
    
    }

    
}