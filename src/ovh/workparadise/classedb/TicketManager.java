package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TicketManager {
	private ResultSet result;
	
	public ArrayList<Ticket> loadAll(ConnectionDB connect) {
		String sql = "SELECT * FROM ticket";
		
		this.result = connect.getData(sql, null);
		Ticket ticket = null;
		ArrayList<Ticket> list = new ArrayList<Ticket>();
		
		try {
			while(this.result.next()) {
					ticket = new Ticket(
							this.result.getInt("id"),
							this.result.getInt("idUser"),
							this.result.getString("categorie"),
							this.result.getString("subject"),
							this.result.getBoolean("status"));
					list.add(ticket);
					
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur SQL c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return list;
	}
}
