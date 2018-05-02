package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MakeReservationManager {
	private ResultSet result;
	
	public ArrayList<MakeReservation> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM makereservation";
		
		this.result = connect.getData(sql, null);
		ArrayList<MakeReservation> list = new ArrayList<MakeReservation>();
		MakeReservation user = null;
		try {
			while(this.result.next()) {
				user = new MakeReservation(this.result.getInt("idUser"),
						this.result.getInt("idReservation"),
						this.result.getString("status"));
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
