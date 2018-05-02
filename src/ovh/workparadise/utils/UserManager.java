package ovh.workparadise.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

import ovh.workparadise.classedb.ConnectionDB;
import ovh.workparadise.classedb.Parameter;

public class UserManager {
	private ResultSet result;
	private User base;
	private User user;
	
	public UserManager(User user) {
		this.base = user;
		this.user = null;
	}
	
	@SuppressWarnings({ "rawtypes" })
	private void loadUser() {
		String sql = "SELECT email, pwd, admin FROM users WHERE email= ?";
		User user = new User();
		ConnectionDB connect = ConnectionDB.getInstance(Configuration.getInstance().generateUrl());
		ArrayList<Parameter> list = new ArrayList<Parameter>();
		
		list.add(new Parameter<String>(this.base.getEmail()));
		this.result = connect.getData(sql, list);
		try {
			if(this.result != null) {
				while(this.result.next()) {
					user.setEmail(this.result.getString("email"));
					user.setPwd(this.result.getString("pwd"));
					user.setAdmin(this.result.getBoolean("admin"));
				}
			}
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur SQL c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		
		}finally {
			connect.clearSql();
		}
		
		this.user = user;
		
	}
	
	private boolean checkEmail() {
		if(this.base.getEmail().equals(user.getEmail())) {
			return true;
		}
		return false;
	}
	
	private boolean checkPwd() {
		return BCrypt.checkpw(this.base.getPwd(), this.user.getPwd());
	}
	
	private boolean checkAdmin() {
		return this.user.getAdmin();
	}
	
	public boolean checkAccount() {
		this.loadUser();
		if(this.checkEmail() == true && this.checkPwd() == true && this.checkAdmin() == true) {
			return true;
		}
		return false;
	}
	
}
