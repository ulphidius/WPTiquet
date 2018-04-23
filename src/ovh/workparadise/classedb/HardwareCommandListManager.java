package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HardwareCommandListManager {
	private ResultSet result;
	
	public ArrayList<HardwareCommandList> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM hardwarecommandlist";
		
		this.result = connect.getData(sql, null);
		ArrayList<HardwareCommandList> list = new ArrayList<HardwareCommandList>();
		HardwareCommandList user = null;
		try {
			while(this.result.next()) {
				user = new HardwareCommandList(this.result.getInt("id"),
						this.result.getInt("idReservation"),
						this.result.getInt("idHardware"),
						this.result.getString("originalState"),
						this.result.getString("afterState"));
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
