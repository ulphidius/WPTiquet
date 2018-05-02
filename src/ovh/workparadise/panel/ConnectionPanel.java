package ovh.workparadise.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.mindrot.jbcrypt.BCrypt;

import ovh.workparadise.button.SkeletonButton;
import ovh.workparadise.utils.User;
import ovh.workparadise.utils.UserManager;

public class ConnectionPanel extends JPanel{
	
	private static final long serialVersionUID = 3345650137435055586L;
	
	private JTextField email = null;
	private JPasswordField pwd = null;
	
	public ConnectionPanel() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(15, 15));
		
		this.email = new JTextField("Entrez votre email");
		this.email.setPreferredSize(new Dimension(150, 25));
		
		this.pwd = new JPasswordField();
		this.pwd.setPreferredSize(new Dimension(150, 25));
		this.pwd.setEchoChar('•');
		
		SkeletonButton button = new SkeletonButton("Connexion");
		button.setSize(new Dimension(20, 20));
		button.addActionListener(new ButtonListener1());
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(this.email);
		panel.add(this.pwd);
		panel.add(button);
		this.add(new JLabel("                                                         "), BorderLayout.WEST);
		this.add(new JLabel("                                                         "), BorderLayout.EAST);
		this.add(panel, BorderLayout.CENTER);
		
	}
	
	class ButtonListener1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			User user = new User(email.getText(), pwd.getPassword());
			UserManager manager = new UserManager(user);
			// TODO password char [] into String and check UserManager
			
		}
		
	}
}
