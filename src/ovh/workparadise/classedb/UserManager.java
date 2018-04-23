package ovh.workparadise.classedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManager {
	private ResultSet result;
	
	public ArrayList<User> loadAllUser(ConnectionDB connect) {
		
		String sql = "SELECT * FROM users";
		
		this.result = connect.getData(sql, null);
		ArrayList<User> list = new ArrayList<User>();
		User user = null;
		try {
			while(this.result.next()) {
				user = new User(this.result.getInt("id"),
						this.result.getString("firstname"),
						this.result.getString("lastname"),
						this.result.getString("email"),
						this.result.getString("phoneN"),
						this.result.getString("secret"),
						this.result.getString("pwd"),
						this.result.getBoolean("status"),
						this.result.getBoolean("admin"));
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
