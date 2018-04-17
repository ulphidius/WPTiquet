package ovh.workparadise.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ovh.workparadise.button.SkeletonButton;

public class ConnectionPanel extends JPanel{
	
	private static final long serialVersionUID = 3345650137435055586L;

	public ConnectionPanel() {
		JPanel content = new JPanel();
		
		JTextField field = new JTextField("Entrez votre email");
		field.setPreferredSize(new Dimension(150, 25));
		
		JPasswordField field2 = new JPasswordField("Entrez votre motde passe");
		field2.setPreferredSize(new Dimension(150, 25));
		field2.setEchoChar('•');
		
		SkeletonButton button = new SkeletonButton("Connexion");
		button.setSize(new Dimension(20, 20));
		
		this.add(field);
		this.add(field2);
		this.add(button);
		
	}
}
