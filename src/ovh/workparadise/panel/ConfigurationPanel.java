package ovh.workparadise.panel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigurationPanel extends JPanel{
	public ConfigurationPanel() {
		this.setLayout(new GridLayout(15, 15));
		
		JTextField field = new JTextField("Entrez votre email");
		field.setPreferredSize(new Dimension(150, 25));
		
		JTextField field2 = new JTextField("Entrez votre email");
		field.setPreferredSize(new Dimension(150, 25));
		
		JTextField field3 = new JTextField("Entrez votre email");
		field.setPreferredSize(new Dimension(150, 25));
		
		JTextField field4 = new JTextField("Entrez votre email");
		field.setPreferredSize(new Dimension(150, 25));
		
		JTextField field5 = new JTextField("Entrez votre email");
		field.setPreferredSize(new Dimension(150, 25));
		
		JTextField field6 = new JTextField("Entrez votre email");
		field.setPreferredSize(new Dimension(150, 25));
	}
}
