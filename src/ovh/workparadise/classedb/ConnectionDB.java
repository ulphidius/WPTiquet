package ovh.workparadise.classedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionDB {
	private String _url;
	private String _user;
	private String _pwd;
	private String _request;
	private Connection _connection = null;
	private PreparedStatement _statement = null;
	
	public ConnectionDB(String dbName) {
		this._url = "jdbc:mysql://localhost:3306/" + dbName;
		this._user = "test";
		this._pwd = "test";
	}
	
	public ConnectionDB(String dbName, String type) {
		this(dbName);
		this._url = "jdbc:" + type + "://localhost:3306/" + dbName;
	}
	
	public ConnectionDB(String dbName, String type, String ip) {
		this(dbName, type);
		this._url = "jdbc:" + type + "://" + ip + ":3306/" + dbName;
	}
	
	public ConnectionDB(String dbName, String type, String ip, String number) {
		this(dbName, type, ip);
		this._url = "jdbc:" + type + "://" + ip + ":" + number + "/" + dbName;
	}
	
	public ConnectionDB(String dbName, String type, String ip, String number, String user, String pwd) {
		this(dbName, type, ip, number);
		this._user = user;
		this._pwd = pwd;
	}

	// Getter
	
	public String getUrl() {
		return this._url;
	}

	public String getUser() {
		return this._user;
	}
	
	public String getPwd() {
		return this._pwd;
	}
	
	public String getRequest() {
		return this._request;
	}
	
	public Connection getConnection() {
		return this._connection;
	}
	
	public PreparedStatement getStatement() {
		return this._statement;
	}
	
	// Setter
	
	public void setUrl(String url) {
		this._url = url;
	}
	
	public void set_user(String user) {
		this._user = user;
	}
	
	public void set_pwd(String pwd) {
		this._pwd = pwd;
	}

	public void set_request(String request) {
		this._request = request;
	}

	public void set_connection(Connection connection) {
		this._connection = connection;
	}

	public void set_statement(PreparedStatement statement) {
		this._statement = statement;
	}
	
	// Méthode
	
	public void driverConnection() {
		try{
			this._connection = DriverManager.getConnection( this._url, this._user, this._pwd);	
		
		}catch(SQLException e) {
			e.printStackTrace();
		
		}
		
	}
	
	public void prepareRequest(String sqlLine) {
		try {
			this._statement = this._connection.prepareStatement(sqlLine);
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	/*public void completeRequest(ArrayList<Parameter> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getType() == "int") {
				this._statement.setInt(i, ((int) list.get(i)).intValue());
				
			}else if(list.get(i).getType() == "String") {
				this._statement.setString(i, ((String) list.get(i)));
				
			}else if(list.get(i).getType() == "float") {
				this._statement.setFloat(i, ((float) list.get(i)).floatValue());
				
			}
		}
	}*/
}
