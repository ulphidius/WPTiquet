package ovh.workparadise.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MenuPanel extends JPanel{
	
	private static final long serialVersionUID = -3317870245421530323L;
	
	private static final int size = 50;
	
	public MenuPanel() {
		this.setLayout(new BorderLayout());
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.LEFT);
		TiquetPanel tiquet = new TiquetPanel();
		EquipementPanel equipement = new EquipementPanel();
		ExcelPanel excel = new ExcelPanel();
		
		tabs.addTab("Tiquet", tiquet);
		tabs.setIconAt(0, new ImageIcon(new ImageIcon("Resources/ticket.png").getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT)));
		
		tabs.addTab("Matériel", equipement);
		tabs.setIconAt(1, new ImageIcon (new ImageIcon("Resources/equipements.png").getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT)));
				
		tabs.addTab("Excel", excel);
		tabs.setIconAt(2,  new ImageIcon(new ImageIcon("Resources/excel.png").getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT)));
		content.add(tabs);
		
		this.add(content);
	
	}
}
