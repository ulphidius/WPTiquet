package ovh.workparadise.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Configuration {
	private String dbname;
	private String type;
	private String ip;
	private String number;
	private String user;
	private String password;
	private String driver;
	private File file;
	
	private static Configuration INSTANCE = null;
	
	private Configuration() {
		this.dbname = null;
		this.type = null;
		this.ip = null;
		this.number = null;
		this.user = null;
		this.password = null;
		this.driver = null;
		this.file = null;
	}
	
	public static Configuration getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Configuration();
		}
		
		return INSTANCE;
	}
	
	// Getter
	
	public String getDbname() {
		return this.dbname;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getDriver() {
		return this.driver;
	}
	
	public File getFile() {
		return this.file;
	}
	
	// Setter
	
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	// Writer
	public void writeConf() {
		Properties props = null;
		OutputStream out = null;
		try {
			props = new Properties();
			props.setProperty("dbname", (this.dbname == null) ? "null" : this.dbname);
			props.setProperty("type", (this.type == null) ? "null" : this.type);
			props.setProperty("ip", (this.ip == null) ? "null" : this.ip);
			props.setProperty("number", (this.number == null) ? "null" : this.number);
			props.setProperty("user", (this.user == null) ? "null" : this.user);
			props.setProperty("password", (this.password == null) ? "null" : this.password);
			props.setProperty("driver", (this.driver == null) ? "null" : this.driver);
			out = new FileOutputStream(this.file);
			props.store(out, "C'est un fichier de configuration il est preferable de ne pas le supprimer ou l'editer manuellement");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// Reader
	
	public void readDbname(Properties props) {
		this.dbname = props.getProperty("dbname");
	}
	
	public void readType(Properties props) {
		this.type = props.getProperty("type");
	}
	
	public void readId(Properties props) {
		this.ip = props.getProperty("ip");
	}
	
	public void readNumber(Properties props) {
		this.number = props.getProperty("number");
	}
	
	public void readUser(Properties props) {
		this.user = props.getProperty("user");
	}
	
	public void readPassword(Properties props) {
		this.password = props.getProperty("password");
	}
	
	public void readDriver(Properties props) {
		this.driver = props.getProperty("driver");
	}
	
	public Properties readFile() {
		Properties props = null;
		FileInputStream input = null;
		try {
			props = new Properties();
			input = new FileInputStream(this.file.getAbsolutePath());
			props.load(input);
			this.dbname = props.getProperty("dbname");
			this.type = props.getProperty("type");
			this.ip = props.getProperty("ip");
			this.number = props.getProperty("number");
			this.user = props.getProperty("user");
			this.password = props.getProperty("password");
			this.driver = props.getProperty("driver");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		
		}finally {
			if(input != null) {
				try {
					input.close();
				
				} catch (IOException e) {
					e.printStackTrace();
				
				}				
			}

		}
		return props;
	}
	
	// Vérification d'un fichier de configuration
	
	public void configurationFileExist() {
		this.file = new File("Configuration/conf.txt");
		Properties props = null;
		OutputStream out = null;
		if(!this.file.exists()) {
			try {
				this.file.getParentFile().createNewFile();
				out  = new FileOutputStream(this.file);
				props = new Properties();
				props.setProperty("dbname", "WORKPARADISE");
				props.setProperty("type", "mysql");
				props.setProperty("ip", "localhost");
				props.setProperty("number", "3306");
				props.setProperty("user", "test");
				props.setProperty("password", "test");
				props.setProperty("driver", "com.mysql.cj.jdbc.Driver");
				props.store(out, "C'est un fichier de configuration il est preferable de ne pas le supprimer ou l'editer manuellement");
				
			} catch (IOException e) {
				e.printStackTrace();
			
			}finally {
				if(out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public String generateUrl() {
		return "jdbc:" + this.type + "://" + this.ip + ":" + this.number + "/" + this.dbname + 
				"?verifyServerCertificate=false&useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	}
	
	@ Override
	public String toString() {
		return "[dbaname="+this.dbname+", type="+this.type+", ip="+this.ip+", number="+this.number+", user="+this.user+", password="+this.password+", file="+this.file.getAbsolutePath()+"]";
	}
}
