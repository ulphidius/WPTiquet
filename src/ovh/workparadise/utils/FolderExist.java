package ovh.workparadise.utils;

import java.io.File;

public class FolderExist {
	private final String conf = "Configuration";
	private final String Excel = "Excel";
	
	/**
	 * Création des dossiers en cas de non existance
	 */
	public void createFolder() {
		if(!new File(conf).exists() || !new File(conf).isDirectory()) {
			new File(conf).mkdir();
		}
		if(!new File(Excel).exists() || !new File(Excel).isDirectory()) {
			new File(Excel).mkdir();
		}
	}
}
