package ovh.workparadise.button;

import java.awt.Color;
import java.awt.event.MouseEvent;

import ovh.workparadise.classedb.User;

public class ConnectionButton extends SkeletonButton{
	private User _user;
	private static final long serialVersionUID = 3380741902191098565L;

	public ConnectionButton(String name, User user) {
		super(name);
		this._user = user;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.setForeground(Color.BLACK);
		// TODO a if statement who check the input date + load the new panel
		
		
	}
}
