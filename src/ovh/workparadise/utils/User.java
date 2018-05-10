package ovh.workparadise.utils;

public class User {
	private String email;
	private String pwd;
	private boolean admin;
	
	public User() {
		this.email = null;
		this.pwd = null;
		this.admin = false;
	}
	public User(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
		this.admin = false;
	}
	
	public User(String email, String pwd, Boolean admin) {
		this(email, pwd);
		this.admin = admin;
	}
	

	public String getEmail() {
		return this.email;
	}

	public String getPwd() {
		return this.pwd;
	}
	
	public Boolean getAdmin() {
		return this.admin;
	}
	
	public void setEmail(String _email) {
		this.email = _email;
	}
	
	public void setPwd(String _pwd) {
		this.pwd = _pwd;
	}
	
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "User [_email=" + this.email + ", _pwd=" + this.pwd + ", admin=" + this.admin + "]";
	}
	
}
