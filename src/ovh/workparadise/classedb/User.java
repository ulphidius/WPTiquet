package ovh.workparadise.classedb;

public class User {
	private int _id;  
	private String _firstname;
	private String _lastname;
	private String _email;
	private String _phoneN;
	private String _pwd;
	private String _secret;
	private boolean _status;
	private boolean _admin;
	private final int number = 9;
	
	public User(int id, String firstname, String lastname, String email, String phoneN, String pwd, String secret, boolean status, boolean admin) {
		this._id = id;
		this._firstname = firstname;
		this._lastname = lastname;
		this._email = email;
		this._phoneN = phoneN;
		this._pwd = pwd;
		this._secret = secret;
		this._status = status;
		this._admin = admin;
	}
	
	public int getId() {
		return this._id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public String getFirstname() {
		return this._firstname;
	}

	public void setFirstname(String _firstname) {
		this._firstname = _firstname;
	}

	public String getLastname() {
		return this._lastname;
	}

	public void setLastname(String _lastname) {
		this._lastname = _lastname;
	}

	public String getEmail() {
		return this._email;
	}

	public void setEmail(String _email) {
		this._email = _email;
	}

	public String getPhoneN() {
		return this._phoneN;
	}

	public void setPhoneN(String _phoneN) {
		this._phoneN = _phoneN;
	}

	public String getPwd() {
		return this._pwd;
	}

	public void setPwd(String _pwd) {
		this._pwd = _pwd;
	}

	public String getSecret() {
		return this._secret;
	}

	public void setSecret(String _secret) {
		this._secret = _secret;
	}

	public boolean getStatus() {
		return this._status;
	}

	public void setStatus(boolean _status) {
		this._status = _status;
	}

	public boolean getAdmin() {
		return this._admin;
	}

	public void setAdmin(boolean _admin) {
		this._admin = _admin;
	}
	
	public int getNumber() {
		return this.number;
	}

	@Override
	public String toString() {
		return "User [_id=" + this._id + ", _firstname=" + this._firstname + ", _lastname=" + this._lastname + ", _email=" + this._email
				+ ", _phoneN=" + this._phoneN + ", _pwd=" + this._pwd + ", _secret=" + this._secret + ", _status=" + this._status
				+ ", _admin=" + this._admin + "]";
	}
	
}
