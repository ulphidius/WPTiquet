package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MessageManager {
	private ResultSet result;
	
	public ArrayList<Message> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM message";
		
		this.result = connect.getData(sql, null);
		ArrayList<Message> list = new ArrayList<Message>();
		Message user = null;
		try {
			while(this.result.next()) {
				user = new Message(this.result.getInt("id"),
						this.result.getString("email"),
						this.result.getString("message")
						);
				list.add(user);
				
			}
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur SQL c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		
		}finally {
			connect.clearSql();
		
		}
		connect.clearSql();
		return list;
	}
}
