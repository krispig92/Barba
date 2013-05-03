package barba;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controller implements KeyListener, MouseListener, MouseMotionListener{

	public float mouseX, mouseY;
	public boolean[] characters = new boolean[255];
	public boolean hoppa = true;
	public boolean pressed = false;
	
	public Controller(Component parent) {
		// S�tt kontrollern till lyssnare p� en komponent
		parent.addMouseListener(this);
		parent.addMouseMotionListener(this);
		parent.addKeyListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	/*
	 * Lyssnar p� musens position och sparar undan
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY = arg0.getY();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	/*
	 * Metoder s�tter en flagga till sann eller falsk beroende på
	 * tangenters status.
	 */
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		characters[arg0.getKeyCode()] = true;
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE){
			if(pressed){
				characters[arg0.getKeyCode()] = false;
			}				
		}
}

	@Override
	public void keyReleased(KeyEvent arg0) {
		characters[arg0.getKeyCode()] = false;
		
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE){
						
			pressed = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		characters[arg0.getKeyCode()] = false;
	}
}