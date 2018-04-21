package ovh.workparadise.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ovh.workparadise.button.SkeletonButton;

public class ConnectionPanel extends JPanel{
	
	private static final long serialVersionUID = 3345650137435055586L;

	public ConnectionPanel() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(15, 15));
		
		JTextField field = new JTextField("Entrez votre email");
		field.setPreferredSize(new Dimension(150, 25));
		
		JPasswordField field2 = new JPasswordField();
		field2.setPreferredSize(new Dimension(150, 25));
		field2.setEchoChar('•');
		
		SkeletonButton button = new SkeletonButton("Connexion");
		button.setSize(new Dimension(20, 20));
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(field);
		panel.add(field2);
		panel.add(button);
		this.add(new JLabel("                                                         "), BorderLayout.WEST);
		this.add(new JLabel("                                                         "), BorderLayout.EAST);
		this.add(panel, BorderLayout.CENTER);
		
	}
}
