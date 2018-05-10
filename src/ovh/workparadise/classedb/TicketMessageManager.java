package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TicketMessageManager {
	private ResultSet result;
	
	public ArrayList<TicketMessage> loadAll(ConnectionDB connect){
		String sql = "SELECT * FROM ticketmessage";
		TicketMessage ticket = null;
		ArrayList<TicketMessage> list = new ArrayList<TicketMessage>();
		
		this.result = connect.getData(sql, null);
		try {
			while(this.result.next()) {
				ticket = new TicketMessage(
							this.result.getInt("id"),
							this.result.getInt("idTicket"),
							this.result.getString("content"),
							this.result.getTimestamp("dateSend").toString(),
							this.result.getBoolean("type")
						);
				list.add(ticket);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Une erreur SQL c'est produite", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return list;
	}
}
