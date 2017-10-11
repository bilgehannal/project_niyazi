package com.Substructure;

import java.awt.event.KeyEvent;

import com.PropertiesOfObjects.Motion;
import com.Shape.Shape;
import com.UsefulItems.List;

public class Player {
	
	//Player properties are defined.
	private Shape shape;
	private Screen screen;
	private int speed;
	public final Motion motion; //Motion object is defined.
	
	
	public Player(Shape shape, Screen screen) {
		this.shape = shape;
		this.screen = screen;
		motion = new Motion(this); //Motuion object is created, it has motion properties of shapes.
		
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
	
	
	
	
	

}
