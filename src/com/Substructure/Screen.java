package com.Substructure;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.PropertiesOfObjects.Behaviour;

public abstract class Screen {

	
	private final ScreenFactory screenFactory;
	
	public Screen(ScreenFactory screenFactory){
		this.screenFactory = screenFactory;

	}
	
	//Abstract Methods (Theese methods must be used in subClass)
	public abstract void setup();
	
	public abstract void action();
	
	
	
	//Returning screenFactory method.
	public ScreenFactory getScreenFactory(){
		return screenFactory;
	}
	
	
	//Keyboard Actions.
	public boolean isKeyPressed(int key){
		return this.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(key);
	}
	
	public boolean isKeyReleased(int key){
		return this.getScreenFactory().getGame().getKeyboardListener().isKeyReleased(key);
	}
	
	//Mouse Actions.
	public boolean isMousePressed(){
		return this.getScreenFactory().getGame().getMousePadListener().isMousePressed();
	}
	
	public int getX(){
		return this.getScreenFactory().getGame().getMousePadListener().getX();
	}
	
	public int getY(){
		return this.getScreenFactory().getGame().getMousePadListener().getY();
	}
	
	//displayUpdate Method is updating the size of frame to activate. 
	public void displayUpdate(){
		int windowX = this.getScreenFactory().getGame().getWindowX();
		int windowY = this.getScreenFactory().getGame().getWindowY();
		this.getScreenFactory().getGame().getWindow().setSize(windowX+1, windowY+1);
		this.getScreenFactory().getGame().getWindow().setSize(windowX, windowY);
		
	}
	
	

}
