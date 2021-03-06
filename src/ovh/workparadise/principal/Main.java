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
import ovh.workparadise.utils.FolderExist;

public class Main {
	public static void main(String[] args) {
		
		FolderExist folder = new FolderExist();
		folder.createFolder();
		Configuration.getInstance().configurationFileExist();
		Configuration.getInstance().readFile();
		
		ConnectionDB.getInstance(Configuration.getInstance().generateUrl());
		ConnectionDB.getInstance(Configuration.getInstance().generateUrl()).driverLoad(Configuration.getInstance().getDriver());
		
		JFrame frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setMinimumSize(new Dimension(1080, 720));
		frame.setMaximumSize(new Dimension(1900, 1080));
		frame.setTitle("Workparadise");
		frame.setLocationRelativeTo(null);
		
		ConnectionPanel content = new ConnectionPanel(frame);
		
		frame.setContentPane(content);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		return;
	}
}
