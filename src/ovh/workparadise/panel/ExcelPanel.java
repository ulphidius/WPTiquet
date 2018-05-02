package ovh.workparadise.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ovh.workparadise.button.SkeletonButton;
import ovh.workparadise.classedb.ConnectionDB;
import ovh.workparadise.excel.ProcessExport;
import ovh.workparadise.utils.Configuration;

public class ExcelPanel extends JPanel{

	private static final long serialVersionUID = 2539420442258270353L;
	
	JTextField field = null;
	public ExcelPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbl = new GridBagConstraints();
		
		
		field = new JTextField("Entrez le nom du fichier");
		field.setPreferredSize(new Dimension(150, 25));
		 
		SkeletonButton button = new SkeletonButton("Export Data Base");
		button.addActionListener(new ButtonListener1());
		
		gbl.gridx = 0;
		gbl.gridy = 0;
		gbl.gridheight = 1;
		gbl.gridwidth = GridBagConstraints.REMAINDER;
		
		this.add(this.field, gbl);
		gbl.gridx = 0;
		gbl.gridy = 1;
		this.add(button, gbl);
		
	}
	
	class ButtonListener1 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ProcessExport ex = new ProcessExport((field.getText() == null) ? "ExportDataBase" : field.getText().trim());
			ex.exportExcel(ConnectionDB.getInstance(Configuration.getInstance().generateUrl()));
		}
	}
}
