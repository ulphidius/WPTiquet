package ovh.workparadise.classedb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectionDB {
	private String _url;
	private String _user;
	private String _pwd;
	private String _request;
	private Connection _connection = null;
	private PreparedStatement _statement = null;
	private ResultSet _result = null;
	
	private static ConnectionDB SINGLETON = null;
	
	private ConnectionDB(String url) {
		this._url = url;
		this._user = "test";
		this._pwd = "test";
	}
	
	public static ConnectionDB getInstance(String url) {
		if(SINGLETON == null) {
			SINGLETON = new ConnectionDB(url);
		}
		return SINGLETON;
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
	
	public ResultSet getResult() {
		return this._result;
	}
	
	// Setter
	
	public void setUrl(String url) {
		this._url = url;
	}
	
	public void setUser(String user) {
		this._user = user;
	}
	
	public void setPwd(String pwd) {
		this._pwd = pwd;
	}

	public void setRequest(String request) {
		this._request = request;
	}

	public void setConnection(Connection connection) {
		this._connection = connection;
	}

	public void setStatement(PreparedStatement statement) {
		this._statement = statement;
	}
	
	public void setResult(ResultSet result) {
		this._result = result;
	}
	
	// Méthode
	
	public void driverLoad(String driver) {
		try {
			Class.forName(driver);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
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
	
	public void completeRequest(@SuppressWarnings("rawtypes") ArrayList<Parameter> list) {
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				try {
					if(list.get(i).getType() == "int") {
						this._statement.setInt(i, (int)list.get(i).get());
						
					}else if(list.get(i).getType() == "String") {
						this._statement.setString(i, (String)list.get(i).get());
						
					}else if(list.get(i).getType() == "float") {
						this._statement.setFloat(i, (float)list.get(i).get());
						
					}else if(list.get(i).getType() == "double") {
						this._statement.setDouble(i, (double)list.get(i).get());
						
					}else if(list.get(i).getType() == "long") {
						this._statement.setLong(i, (long)list.get(i).get());
						
					}else if(list.get(i).getType() == "Date") {
						this._statement.setDate(i, (Date)list.get(i).get());
						
					}else if(list.get(i).getType() == "boolean"){
						this._statement.setBoolean(i, (boolean)list.get(i).get());
						
					}else {
						System.out.println("Erreur type de données inconnu");
						return;
					}
				
				}catch(SQLException e) {
					e.printStackTrace();
					
				}
			}
		}
	}
	
	public ResultSet returnExecute() {
		try {
			this._result = this._statement.executeQuery();
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return this._result;
		
	}
	
	public void noReturnExecute() {
		try {
			this._statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void clearSql() {
		this.clearConnection();
		this.clearRequest();
		this.clearResult();
		
	}
	
	public void clearRequest() {
		try {
			if(this._statement != null) {
				this._statement.close();
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	public void clearConnection() {
		try {
			if(this._connection != null) {
				this._connection.close();
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	public void clearResult() {
		try {
			if(this._result != null) {
				this._result.close();
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	public void updateData(String sql, @SuppressWarnings("rawtypes") ArrayList<Parameter> list) {
		this.driverConnection();
		this.prepareRequest(sql);
		this.completeRequest(list);
		this.noReturnExecute();
		this.clearSql();
		
	}
	
	public ResultSet getData(String sql, @SuppressWarnings("rawtypes") ArrayList<Parameter> list) {
		this.driverConnection();
		this.prepareRequest(sql);
		this.completeRequest(list);
		return this.returnExecute();
		// Ne pas oublier de clear 
	}

	@Override
	public String toString() {
		return "ConnectionDB [_url=" + this._url + ", _user=" + this._user + ", _pwd=" + this._pwd + ", _request=" + this._request
				+ ", _connection=" + this._connection + ", _statement=" + this._statement + ", _result=" + this._result + "]";
	}
	
}
