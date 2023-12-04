package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	/**
	 * This are use to store the signing details
	 */
	public int user_id;
    public String user_name;
    public String user_email;
    public String user_game_name;
    public String user_password;
    
    
	public User(String user_name, String user_email, String user_game_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_game_name = user_game_name;
		this.user_password = user_password;
	}
	public User(String user_email, String user_password, String user_game_name) {
		super();
		this.user_email = user_email;
		this.user_game_name = user_game_name;
		this.user_password = user_password;

	}
	public User(String user_email, String user_password ) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
	}
	
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