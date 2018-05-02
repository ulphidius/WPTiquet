package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RoomManager {
	private ResultSet result;
	
	public ArrayList<Room> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM room";
		
		this.result = connect.getData(sql, null);
		ArrayList<Room> list = new ArrayList<Room>();
		Room user = null;
		try {
			while(this.result.next()) {
				user = new Room(this.result.getInt("id"),
						this.result.getInt("site"),
						this.result.getString("type"),
						this.result.getString("description"),
						this.result.getInt("roomNumber"),
						this.result.getString("roomStatus"));
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
