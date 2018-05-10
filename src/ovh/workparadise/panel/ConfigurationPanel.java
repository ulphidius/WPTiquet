package ovh.workparadise.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ovh.workparadise.button.SkeletonButton;
import ovh.workparadise.utils.Configuration;

public class ConfigurationPanel extends JPanel{

	private static final long serialVersionUID = 627617857646179164L;
	
	private JTextField dbname = null;
	private JTextField type = null;
	private JTextField ip = null;
	private JTextField number = null;
	private JTextField user = null;
	private JTextField pwd = null;
	private JTextField driver = null;
	
	public ConfigurationPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new GridLayout(15, 15));
		
		this.dbname = new JTextField("Entrez le nom de la base");
		this.dbname.setPreferredSize(new Dimension(160, 25));
		
		this.type = new JTextField("Entrez le type");
		this.type.setPreferredSize(new Dimension(150, 25));
		
		this.ip = new JTextField("Entrez votre ip");
		this.ip.setPreferredSize(new Dimension(150, 25));
		
		this.number = new JTextField("Entrez votre numero de port");
		this.number.setPreferredSize(new Dimension(150, 25));
		
		this.user = new JTextField("Entrez votre user");
		this.user.setPreferredSize(new Dimension(150, 25));
		
		this.pwd = new JTextField("Entrez votre mot de passe");
		this.pwd.setPreferredSize(new Dimension(150, 25));
		
		this.driver = new JTextField("Entrez votre driver");
		this.driver.setPreferredSize(new Dimension(150, 25));
		
		SkeletonButton button = new SkeletonButton("Envoyer");
		button.addActionListener(new ButtonListener1());
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel("Les champs vides à l'envoie seront laissés par defaut"));
		panel.add(this.dbname);
		panel.add(this.type);
		panel.add(this.ip);
		panel.add(this.number);
		panel.add(this.user);
		panel.add(this.pwd);
		panel .add(this.driver);
		panel.add(button);
		
		this.add(new JLabel("                                                         "), BorderLayout.WEST);
		this.add(new JLabel("                                                         "), BorderLayout.EAST);
		this.add(panel, BorderLayout.CENTER);
		
	}
	
	class ButtonListener1 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Configuration conf = Configuration.getInstance();
			conf.readFile();
			conf.setDbname((dbname.getText() == null || dbname.getText().equals("Entrez le nom de la base")) ? conf.getDbname() : dbname.getText());
			conf.setType((type.getText() == null ||type.getText().equals("Entrez le type")) ? conf.getType() : type.getText());
			conf.setIp((ip.getText() == null || ip.getText().equals("Entrez votre ip")) ? conf.getIp() : ip.getText());
			conf.setNumber((number.getText() == null || number.getText().equals("Entrez votre numero de port")) ? conf.getNumber() : number.getText());
			conf.setUser((user.getText() == null ||user.getText().equals("Entrez votre user")) ? conf.getUser() : user.getText());
			conf.setPassword((pwd.getText() == null || pwd.getText().equals("Entrez votre mot de passe")) ? conf.getPassword() : pwd.getText());
			conf.setDriver((driver.getText() == null || driver.getText().equals("Entrez votre driver")) ? conf.getDriver() : driver.getText());
			conf.writeConf();
		}
	}
}
