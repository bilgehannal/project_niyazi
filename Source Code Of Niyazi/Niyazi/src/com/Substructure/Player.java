package com.Substructure;

import java.awt.event.KeyEvent;

import com.Physics.Motion;
import com.Shape.Shape;
import com.UsefulItems.List;

public class Player {
	
	//Player properties are defined.
	private Shape shape;
	private Screen screen;
	private int speed;
	public final Motion motion; //Motion object is defined.
	private Game game;
	
	
	public Player(Shape shape, Screen screen) {
		this.shape = shape;
		this.screen = screen;
		motion = new Motion(this); //Motuion object is created, it has motion properties of shapes.
		game = screen.getScreenFactory().getGame();
		
	}
	
	//Encapsulation methods.
	public Screen getScreen() {
		return screen;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	//This method move the camera to focus the object of player.
	public void focus(){
		int centerX = game.getWindowX()/2-(shape.getWidth()/2), centerY = game.getWindowY()/2-(shape.getHeight()/2);
		game.moveCameraX(shape.getPositionX()-centerX);
		game.moveCameraY(shape.getPositionY()-centerY);
	}
	
	public  void wrap(boolean wrap){
		getShape().behaviour.wrap(wrap);
		
	}
	
	public boolean isWrap(){
		return getShape().behaviour.isWrap();
	}
	
	
	
	
	

}
