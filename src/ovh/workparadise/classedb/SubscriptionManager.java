package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SubscriptionManager {
	private ResultSet result;
	
	public ArrayList<Subscription> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM subscription";
		
		this.result = connect.getData(sql, null);
		ArrayList<Subscription> list = new ArrayList<Subscription>();
		Subscription user = null;
		try {
			while(this.result.next()) {
				user = new Subscription(this.result.getInt("id"),
						this.result.getString("name"),
						this.result.getString("description"),
						this.result.getFloat("hourRate"),
						this.result.getFloat("dayRate"),
						this.result.getFloat("StudentRate"),
						this.result.getFloat("engagementRate"),
						this.result.getFloat("notEngagementRate"),
						this.result.getInt("engagementTime"));
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
