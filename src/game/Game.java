package game;

import java.net.URL;

/**
 * Represents a game with its location and solution.
 */

public class Game {
	
	// Access modifiers made private
	URL location = null; 
	int solution = -1;
	
	
	/**
     * Initializes a new instance of the Game class.
     *
     * @param location The location of the game.
     * @param solution The solution to the game.
     */
	
	public Game(URL location, int solution) {
		super();
		this.location = location;
		this.solution = solution;
	}
	
	/**
     * Gets the location of the game.
     *
     * @return The location of the game.
     */
	public URL getLocation() {
		return location;
	}
	
	/**
     * Gets the solution of the game.
     *
     * @return The solution of the game.
     */
	public int getSolution() {
		return solution;
	}
}
