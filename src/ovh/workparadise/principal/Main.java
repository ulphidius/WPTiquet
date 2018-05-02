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
import ovh.workparadise.utils.Configuration;

public class Main {
	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Paris");
		TimeZone.setDefault(timeZone);

		Configuration.getInstance().configurationFileExist();
		Configuration.getInstance().readFile();
		System.out.println(Configuration.getInstance().generateUrl());
		
		ConnectionDB.getInstance(Configuration.getInstance().generateUrl());
		ConnectionDB.getInstance(Configuration.getInstance().generateUrl()).driverLoad(Configuration.getInstance().getDriver());
		UserManager man = new UserManager();
		
		//ProcessExport excel = new ProcessExport("exportExcel2.xlsx");
		//excel.exportExcel(connect);
		

		
		JFrame frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setMinimumSize(new Dimension(1080, 720));
		frame.setMaximumSize(new Dimension(1900, 1080));
		frame.setTitle("Connexion");
		frame.setLocationRelativeTo(null);
		
		ConnectionPanel content = new ConnectionPanel();
		//MenuPanel content = new MenuPanel();
		frame.setContentPane(content);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		return;
	}
}
