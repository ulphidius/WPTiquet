package ovh.workparadise.button;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class SkeletonButton extends JButton implements MouseListener{
	
	private static final long serialVersionUID = 6394092519145520604L;

	public SkeletonButton(String name) {
		super(name);
		this.addMouseListener(this);
		this.setBackground(Color.blue);
		this.setForeground(Color.white);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.CYAN);
		this.setForeground(Color.black);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.BLUE);
		this.setForeground(Color.white);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setForeground(Color.BLACK);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.setBackground(Color.CYAN);
		this.setForeground(Color.black);
	}
}
