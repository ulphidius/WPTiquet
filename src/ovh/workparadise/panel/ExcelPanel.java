package ovh.workparadise.panel;

import java.awt.Dimension;
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
	
	public ExcelPanel() {
		this.setLayout(new GridLayout(15, 15));
		
		JTextField field = new JTextField("Entrez le nom du fichier");
		field.setPreferredSize(new Dimension(150, 25));
		 
		//ButtonListener
		
	}
	
	class ButtonListener1 extends SkeletonButton implements ActionListener{
		
		private String filename;
		
		public ButtonListener1(String name, String filename) {	
			super(name);
			this.filename = filename;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ProcessExport ex = new ProcessExport(this.filename);
			ex.exportExcel(ConnectionDB.getInstance(Configuration.getInstance().generateUrl()));
		}
	}
}
