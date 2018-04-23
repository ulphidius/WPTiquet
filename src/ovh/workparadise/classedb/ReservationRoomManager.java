package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationRoomManager {
	private ResultSet result;
	
	public ArrayList<ReservationRoom> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM reservationroom";
		
		this.result = connect.getData(sql, null);
		ArrayList<ReservationRoom> list = new ArrayList<ReservationRoom>();
		ReservationRoom user = null;
		try {
			while(this.result.next()) {
				user = new ReservationRoom(this.result.getInt("id"),
						this.result.getInt("idRoom"),
						this.result.getDate("dateR"),
						this.result.getTime("dateStart"),
						this.result.getTime("dateEnd"),
						this.result.getString("originalState"),
						this.result.getString("afterState")
						);
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
