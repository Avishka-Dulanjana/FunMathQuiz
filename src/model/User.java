package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code User} class represents a user in the system and stores user details
 * such as name, email, game name, and password.
 */
public class User {
	/**
	 * This are use to store the signing details
	 */
	public int user_id;
    public String user_name;
    public String user_email;
    public String user_game_name;
    public String user_password;
    
    /**
     * Constructs a new {@code User} with the provided details.
     *
     * @param user_name      The real name of the user.
     * @param user_email     The email address of the user.
     * @param user_game_name The in-game name or username chosen by the user.
     * @param user_password  The password chosen by the user.
     */
	public User(String user_name, String user_email, String user_game_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_game_name = user_game_name;
		this.user_password = user_password;
	}
	
	/**
     * Constructs a new {@code User} with the provided details.
     *
     * @param user_email     The email address of the user.
     * @param user_password  The password chosen by the user.
     * @param user_game_name The in-game name or username chosen by the user.
     */
	public User(String user_email, String user_password, String user_game_name) {
		super();
		this.user_email = user_email;
		this.user_game_name = user_game_name;
		this.user_password = user_password;
	}
	
	/**
     * Constructs a new {@code User} with the provided details.
     *
     * @param user_email    The email address of the user.
     * @param user_password The password chosen by the user.
     */
	public User(String user_email, String user_password ) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
	}
	
	/**
     * Getters and Setters
     *
     * @return The user's unique identifier.
     */
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_game_name() {
		return user_game_name;
	}
	public void setUser_game_name(String user_game_name) {
		this.user_game_name = user_game_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
}