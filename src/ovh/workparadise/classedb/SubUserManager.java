package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubUserManager {
	private ResultSet result;
	
	public ArrayList<SubUser> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM subuser";
		
		this.result = connect.getData(sql, null);
		ArrayList<SubUser> list = new ArrayList<SubUser>();
		SubUser user = null;
		try {
			while(this.result.next()) {
				user = new SubUser(this.result.getInt("idUser"),
						this.result.getInt("idSub"),
						this.result.getBoolean("engaged"),
						this.result.getDate("dateStart"),
						this.result.getDate("dateEnd"));
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
