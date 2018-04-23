package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceCommandManager {
	private ResultSet result;
	
	public ArrayList<ServiceCommand> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM servicecommand";
		
		this.result = connect.getData(sql, null);
		ArrayList<ServiceCommand> list = new ArrayList<ServiceCommand>();
		ServiceCommand user = null;
		try {
			while(this.result.next()) {
				user = new ServiceCommand(this.result.getInt("id"),
						this.result.getString("serviceType"),
						this.result.getString("information"),
						this.result.getFloat("price"),
						this.result.getInt("quantity"),
						this.result.getInt("site"));
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
