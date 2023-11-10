package repo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import controller.GameEngine;
import repo.DatabaseConnection;
import model.SignIn;

public class ScoreData {
	GameEngine gameEngine;
public ScoreData(GameEngine nGameEngine)
{
    this.gameEngine=nGameEngine;
}
public void saveGameScore()
{ // method for add the user registration details to the Database
    try{
        Connection con=DatabaseConnection.createConnection();
        String sql="INSERT INTO scoredata(game_score,game_level)"+"VALUES('"+gameEngine.getScore()+"','"+gameEngine.getLevel()+"')"; 
        PreparedStatement statement=con.prepareStatement(sql);
        statement.executeUpdate();
        con.close(); 
        //JOptionPane.showMessageDialog(null, "User Added Successfully");
               
    } 
    catch(Exception e){
           System.out.println("Error"+e.getLocalizedMessage());
           
    }
    
    }
    
}

//
//package repo;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import javax.swing.JOptionPane;
//import repo.DatabaseConnection;
//import model.SignIn;
//
//public class SaveSignup {
//	SignIn sign;
//public SaveSignup(SignIn sSignUp)
//{
//    this.sign=sSignUp;
//}
//public void saveSignInToDataBase()
//{ // method for add the user registration details to the Database
//    try{
//        Connection con=DatabaseConnection.createConnection();
//        String sql="INSERT INTO signup(user_name,user_game_name,user_email, user_password)"+"VALUES('"+sign.user_name+"','"+sign.user_email+"','"+sign.user_game_name+"','"+sign.user_password+"')"; 
//        PreparedStatement statement=con.prepareStatement(sql);
//        statement.executeUpdate();
//        con.close(); 
//        //JOptionPane.showMessageDialog(null, "User Added Successfully");
//               
//    } 
//    catch(Exception e){
//           System.out.println("Error"+e.getLocalizedMessage());
//           
//    }
//    
//    }
//    
//}