package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MakeReservationManager {
	private ResultSet result;
	
	public ArrayList<MakeReservation> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM makereservation";
		
		this.result = connect.getData(sql, null);
		ArrayList<MakeReservation> list = new ArrayList<MakeReservation>();
		MakeReservation user = null;
		try {
			while(this.result.next()) {
				user = new MakeReservation(this.result.getInt("id"),
						this.result.getInt("idReservation"),
						this.result.getString("status"));
				list.add(user);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			connect.clearSql();
		
		}
		connect.clearSql();
		return list;
	}
}
