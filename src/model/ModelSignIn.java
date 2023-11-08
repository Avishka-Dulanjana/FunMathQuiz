package model;

public class ModelSignIn {
	/**
	 * This are use to store the signing details
	 */
    public String sname;
    public String smail;
    public String spassword;
    
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSmail() {
		return smail;
	}
	public void setSmail(String smail) {
		this.smail = smail;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
 
    /**
	 * This is the constructor to set all the attributes of the Sign class
	 * @param sname
	 * @param smail
	 * @param spassword
	 */
	public ModelSignIn(String sname, String smail, String spassword) {
		super();
		this.sname = sname;
		this.smail = smail;
		this.spassword = spassword;
	}
}
