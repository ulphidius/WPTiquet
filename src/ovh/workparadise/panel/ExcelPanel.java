package ovh.workparadise.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ovh.workparadise.button.SkeletonButton;
import ovh.workparadise.classedb.ConnectionDB;
import ovh.workparadise.excel.ProcessExport;
import ovh.workparadise.utils.Configuration;

public class ExcelPanel extends JPanel{

	private static final long serialVersionUID = 2539420442258270353L;
	
	private JTextField field = null;
	
	public ExcelPanel() {
		this.setLayout(new GridLayout(15, 15));
		
		
		this.field = new JTextField("Entrez le nom du fichier");
		this.field.setPreferredSize(new Dimension(150, 25));
		 
		SkeletonButton button = new SkeletonButton("Export Data Base");
		button.addActionListener(new ButtonListener1());
		
		SkeletonButton button2 = new SkeletonButton("Export Tiquet");
		button2.addActionListener(new ButtonListener2());
		
		for(int i = 0; i < 6; i++) {
			this.add(new JLabel());
		}
		this.add(this.field);
		this.add(button);
		this.add(button2);
		
	}
	
	class ButtonListener1 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ProcessExport ex = new ProcessExport((field.getText() == null) ? "ExportDataBase" : field.getText().trim());
			ex.exportExcel(ConnectionDB.getInstance(Configuration.getInstance().generateUrl()));
		}
	}
	class ButtonListener2 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ProcessExport ex = new ProcessExport((field.getText() == null) ? "ExportTicket" : field.getText().trim());
			ex.exportExcelTicket(ConnectionDB.getInstance(Configuration.getInstance().generateUrl()));
		}
	}
}
