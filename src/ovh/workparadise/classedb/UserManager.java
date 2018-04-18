package ovh.workparadise.classedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
	private static final String _url = "jdbc:mysql://localhost:3306/WORKPARADISE";
	private static final String _user = "test";
	private static final String _pwd = "test";
	private Connection _connection = null;
	private Statement _statement = null;
	private ResultSet _result = null;
	
	public UserManager(User user) {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			this._connection = DriverManager.getConnection( this._url, this._user, this._pwd);
			this._statement = this._connection.prepareStatement( "INSERT INTO Utilisateur (email, pwd) VALUES(?, MD5(?), ?, NOW());" );

			this._result = this._statement.executeQuery( "SELECT email, pwd FROM Users WHERE email = " + user.get_email() + ";" );
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			if(this._connection != null) {
				try {
					this._connection.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			}
		}
	}
	public User getUserEx() {
		User user = null;
		try {
			user = new User(this._result.getString("email"), this._result.getString("pwd"));
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return user;
	}
}
