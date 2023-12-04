package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import repo.DatabaseConnection;

public class ScoreService {
	public static void saveScore(String username, int score) {
        try {
            Connection con = DatabaseConnection.createConnection();
            Statement stm = con.createStatement();
            String query = "insert into score_table (game_id, score) Values(?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setLong(2, score);

            int i = ps.executeUpdate();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
