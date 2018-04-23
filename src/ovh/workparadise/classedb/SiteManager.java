package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SiteManager {
	private ResultSet result;
	
	public ArrayList<Site> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM site";
		
		this.result = connect.getData(sql, null);
		ArrayList<Site> list = new ArrayList<Site>();
		Site user = null;
		try {
			while(this.result.next()) {
				user = new Site(this.result.getInt("id"),
						this.result.getString("name"),
						this.result.getString("address"),
						this.result.getTime("openHourWeek"),
						this.result.getTime("openHourFriday"),
						this.result.getTime("openHourWeekend"),
						this.result.getTime("endHourWeek"),
						this.result.getTime("endHourWeekend"));
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
