package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HardwareCommandManager {
	private ResultSet result;
	
	public ArrayList<HardwareCommand> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM hardwarecommand";
		
		this.result = connect.getData(sql, null);
		ArrayList<HardwareCommand> list = new ArrayList<HardwareCommand>();
		HardwareCommand user = null;
		try {
			while(this.result.next()) {
				user = new HardwareCommand(this.result.getInt("id"),
						this.result.getString("matricule"),
						this.result.getString("hardwareType"),
						this.result.getString("information"),
						this.result.getString("status"),
						this.result.getFloat("price"),
						this.result.getInt("site"));
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
