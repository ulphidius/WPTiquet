package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceCommandListManager {
	private ResultSet result;
	
	public ArrayList<ServiceCommandList> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM servicecommandlist";
		
		this.result = connect.getData(sql, null);
		ArrayList<ServiceCommandList> list = new ArrayList<ServiceCommandList>();
		ServiceCommandList user = null;
		try {
			while(this.result.next()) {
				user = new ServiceCommandList(this.result.getInt("id"),
						this.result.getInt("idService"),
						this.result.getInt("quantity"));
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
