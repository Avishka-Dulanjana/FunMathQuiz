package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignIn {
	/**
	 * This are use to store the signing details
	 */
	public int user_id;
    public String user_name;
    public String user_email;
    public String user_game_name;
    public String user_password;
    
    
	public SignIn(String user_name, String user_email, String user_game_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_game_name = user_game_name;
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
    
	

/////ORIGINAL CODE//////

//package model;
//
//public class SignIn {
//	/**
//	 * This are use to store the signing details
//	 */
//	public int sid;
//    public String sname;
//    public String smail;
//    public String spassword;
//    
//	public String getSname() {
//		return sname;
//	}
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//	public String getSmail() {
//		return smail;
//	}
//	public void setSmail(String smail) {
//		this.smail = smail;
//	}
//	public String getSpassword() {
//		return spassword;
//	}
//	public void setSpassword(String spassword) {
//		this.spassword = spassword;
//	}
// 
//    /**
//	 * This is the constructor to set all the attributes of the Sign class
//	 * @param sname
//	 * @param smail
//	 * @param spassword
//	 */
//	public SignIn(String sname, String smail, String spassword) {
//		super();
//		this.sname = sname;
//		this.smail = smail;
//		this.spassword = spassword;
//	}
//}
