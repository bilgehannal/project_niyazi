package com.Substructure;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
	
	private boolean[] keys = new boolean[256]; //This array keep all integer key of keys.

	@Override
	public void keyTyped(KeyEvent e) {
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public boolean isKeyPressed(int key){
		return keys[key];
	}
	
	public boolean isKeyReleased(int key){
		return !keys[key];
	}
	
	
	

}
