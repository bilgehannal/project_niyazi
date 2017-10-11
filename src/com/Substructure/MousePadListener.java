package com.Substructure;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePadListener implements MouseListener {
	
	private int mouseX, mouseY;
	private boolean clicked = true;
	int mouseBtn = 0;
	

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		mouseBtn = e.getButton();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseClicked(e);
		clicked = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		clicked = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	public boolean isMousePressed(){
		return clicked;
	}
	
	//if mouse pressed this method returns true.
	public boolean isMousePressed(int mouseButton){
		if(isMousePressed() && mouseButton == mouseBtn)
			return true;
		else 
			return false;
	}
	
	
	public int getX(){
		return mouseX;
	}
	
	public int getY(){
		return mouseY;
	}

}
