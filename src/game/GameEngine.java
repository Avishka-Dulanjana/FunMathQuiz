package game;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The GameEngine class represents the main engine responsible for managing games for each player.
 * Games are retrieved from the GameServer, and the player's progress and score are tracked.
 */
public class GameEngine {
	String thePlayer = null;

	 /**
     * Constructs a GameEngine for a specific player.
     *
     * @param player The name of the player
     */
	public GameEngine(String player) {
		thePlayer = player;
	}
	
	// Game-related variables
	int counter = 0;
	int second;
	int score = 0; 
	GameServer theGames = new GameServer(); 
	Game current = null; 
	int level = 1; // Initialize the Level 
	
	/**
     * Retrieves the next game from the GameServer. Handles MalformedURLException if it occurs.
     *
     * @return The URL of the next game, or null in case of an error
     */
	public URL nextGame() {		
			try {
				current = theGames.getRandomGame();
				return current.getLocation(); 
			} catch (MalformedURLException e) {
				System.out.println("Error retrieving the game. Details:"+ e.getMessage()); 
				e.printStackTrace();
				return null; 
			} 
		
	}

	/**
     * Checks if the provided solution is correct for the current game.
     * If correct, increases the score by 10 and advances to the next level.
     *
     * @param game The URL of the current game
     * @param solution The solution to check
     * @return true if the solution is correct, false otherwise
     */
	public boolean checkSolution(URL game, int i) {
		if ( i == current.getSolution() ) {
			score = score + 10; 
			level++; // Increasing Level
			return true;
		} else {
			return false;
		}
	}


	/**
     * Retrieves the player's score.
     *
     * @return The player's score
     */
	public int getScore() {
		return score;
	}
	
	/**
     * Sets the player's score.
     *
     * @param score The new score to set
     */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
     * Retrieves the current level of the player.
     *
     * @return The player's current level
     */
	public int getLevel() {
		// returning Level value
		return level;
	}
	
	/**
     * Sets the player's level.
     *
     * @param level The new level to set
     */
	public void setLevel(int level) {
		this.level = level;
	}
	
}
