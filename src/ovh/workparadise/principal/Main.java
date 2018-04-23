package ovh.workparadise.principal;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.swing.JFrame;

import ovh.workparadise.classedb.ConnectionDB;
import ovh.workparadise.classedb.User;
import ovh.workparadise.classedb.UserManager;
import ovh.workparadise.excel.ProcessExport;
import ovh.workparadise.panel.ConnectionPanel;
import ovh.workparadise.panel.MenuPanel;

public class Main {
	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Paris");
		TimeZone.setDefault(timeZone);
		
		ConnectionDB connect = new ConnectionDB("WORKPARADISE");
		connect.driverLoad("com.mysql.cj.jdbc.Driver");
		
		UserManager man = new UserManager();
		ArrayList<User> list = man.loadAllUser(connect);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		ProcessExport excel = new ProcessExport("exportExcel2.xlsx");
		excel.createSheet("feuille 1");
		excel.generateCellNum("feuille 1", 10, 1, 0);
		excel.generateCellString("feuille 1", "La chance", 2, 0);
		
		/*JFrame frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setMaximumSize(new Dimension(1900, 1080));
		frame.setTitle("Connexion");
		frame.setLocationRelativeTo(null);
		
		//ConnectionPanel content = new ConnectionPanel();
		MenuPanel content = new MenuPanel();
		frame.setContentPane(content);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
		return;
	}
}
