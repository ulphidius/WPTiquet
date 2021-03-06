package ovh.workparadise.classedb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


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
	
	/**
	 * Prend en donnée un String qui est l'url avec les données de connexion de la base de donnée
	 * Si non crée il le fait sinon return la connexion déjà instancié
	 * @param url
	 * @return
	 */
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
	
	/**
	 * Chargement du driver de la base de donnée
	 * @param driver
	 */
	public void driverLoad(String driver) {
		try {
			Class.forName(driver);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Lancement de la connexion avec la base
	 */
	public void driverConnection() {
		try{
			this._connection = DriverManager.getConnection( this._url, this._user, this._pwd);	
		
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur au chargement du driver c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		
		}
		
	}
	
	/**
	 * Préparation d'une requête
	 * Prend en donnée une requête SQL sous forme d'un String
	 * @param sqlLine
	 */
	public void prepareRequest(String sqlLine) {
		try {
			this._statement = this._connection.prepareStatement(sqlLine);
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur à la préparation de la requête c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Complète les "?" d'une requête
	 * Envoie en donnée d'une ArrayList avec les données manquantes
	 * @param list
	 */
	public void completeRequest(@SuppressWarnings("rawtypes") ArrayList<Parameter> list) {
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				try {
					if(list.get(i).getType() == "int") {
						this._statement.setInt(i, (int)list.get(i).get());
						
					}else if(list.get(i).getType() == "String") {
						this._statement.setString(i + 1, (String)list.get(i).get());
						
					}else if(list.get(i).getType() == "float") {
						this._statement.setFloat(i + 1, (float)list.get(i).get());
						
					}else if(list.get(i).getType() == "double") {
						this._statement.setDouble(i + 1, (double)list.get(i).get());
						
					}else if(list.get(i).getType() == "long") {
						this._statement.setLong(i + 1, (long)list.get(i).get());
						
					}else if(list.get(i).getType() == "Date") {
						this._statement.setDate(i + 1, (Date)list.get(i).get());
						
					}else if(list.get(i).getType() == "boolean"){
						this._statement.setBoolean(i + 1, (boolean)list.get(i).get());
						
					}else {
						System.out.println("Erreur type de données inconnu");
						return;
					}
				
				}catch(SQLException e) {
					JOptionPane.showMessageDialog(null, "Une erreur SQL c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
					
				}
			}
		}
	}
	
	/**
	 * Exécute après préparation d'une requête avec un retourn de données 
	 * Retourne un ResultSet
	 * @return
	 */
	public ResultSet returnExecute() {
		try {
			this._result = this._statement.executeQuery();
		
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur SQL à l'exécution de la requête c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		}
		return this._result;
		
	}
	
	/**
	 * Exécute après préparation d'une requête sans retour de données
	 */
	public void noReturnExecute() {
		try {
			this._statement.executeUpdate();
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur SQL à l'exécution de la requête c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * Clear de toute les données
	 */
	public void clearSql() {
		this.clearConnection();
		this.clearRequest();
		this.clearResult();
		
	}
	
	/**
	 * Clear de la requête
	 */
	public void clearRequest() {
		try {
			if(this._statement != null) {
				this._statement.close();
				
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Une erreur au nettoyage des éléments de la requête SQL", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		}		
	}
	
	/**
	 * Clear de la connexion
	 */
	public void clearConnection() {
		try {
			if(this._connection != null) {
				this._connection.close();
				
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Une erreur au nettoyage des éléments de la requête SQL", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		}		
	}
	
	/**
	 * Vider le ResultSet
	 */
	public void clearResult() {
		try {
			if(this._result != null) {
				this._result.close();
				
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Une erreur au nettoyage des éléments de la requête SQL", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		}		
	}
	
	/**
	 * Pour les requêtes de modifiant la base
	 * En paramètre la commande sql + la liste pour complèter les "?" si il y en a (dans le cas contraire envoyer null)
	 * @param sql
	 * @param list
	 */
	
	public void updateData(String sql, @SuppressWarnings("rawtypes") ArrayList<Parameter> list) {
		this.driverConnection();
		this.prepareRequest(sql);
		this.completeRequest(list);
		this.noReturnExecute();
		this.clearSql();
		
	}
	
	/**
	 * Pour les requêtes d'optention de données
	 * En paramètre la commande sql + la liste pour complèter les "?" si il y en a (dans le cas contraire envoyer null)
	 * Retourne un ResultSet avec les données de retour
	 * @param sql
	 * @param list
	 * @return
	 */
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
