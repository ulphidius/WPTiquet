package ovh.workparadise.utils;

public class User {
	private String _email;
	private String _pwd;
	
	public User(String email, String pwd) {
		this._email = email;
		this._pwd = pwd;
	}

	public String get_email() {
		return this._email;
	}

	public String get_pwd() {
		return this._pwd;
	}
	
	public void set_email(String _email) {
		this._email = _email;
	}
	
	public void set_pwd(String _pwd) {
		this._pwd = _pwd;
	}
	
	@Override
	public String toString() {
		return "User [_email=" + this._email + ", _pwd=" + this._pwd + "]";
	}
	
}
