package ovh.workparadise.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import ovh.workparadise.panel.ConnectionPanel;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setMaximumSize(new Dimension(1900, 1080));
		frame.setTitle("Connexion");
		frame.setLocationRelativeTo(null);
		
		ConnectionPanel content = new ConnectionPanel();
		
		frame.setContentPane(content);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return;
	}
}
