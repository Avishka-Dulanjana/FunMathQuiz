package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import repo.DatabaseConnection;

/**
 * The `ScoreService` class provides methods related to handling player scores.
 * It includes functionality to save a player's score in the database.
 */
public class ScoreService {
	
	/**
     * Saves the player's score in the database.
     *
     * @param username The username of the player.
     * @param score    The score achieved by the player.
     */
	public static void saveScore(String username, int score) {
        try {
            Connection con = DatabaseConnection.createConnection();
            Statement stm = con.createStatement();
            String query = "insert into score_table (game_id, score) Values(?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            // Set the values for the parameters
            ps.setString(1, username);
            ps.setLong(2, score);

            // Execute the update and get the result
            int i = ps.executeUpdate();
            
         // Close the prepared statement and database connection
            ps.close();
            con.close();

        } catch (SQLException e) {
            // Handle SQL exceptions, print the stack trace for debugging
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions, print the stack trace for debugging
            e.printStackTrace();
        }
    }

}
