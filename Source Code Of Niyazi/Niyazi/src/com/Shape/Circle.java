package com.Shape;

import java.awt.Graphics2D;

import com.Substructure.Screen;


public class Circle extends Shape  {
	private int radius, width, height, centerX, centerY;
	
	
	
	public Circle( int centerX, int centerY, int radius, Screen screen) {
		//It returns the values as a center, but this constructer send the values to süperclass as a normal x,y variables.
		super( centerX-radius, centerY-radius, screen);
		this.radius = radius;
		setWidth(radius*2);
		setHeight(radius*2);
		
	}
	@Override
	public void show(Graphics2D g2d) {
		g2d.setColor(getColor());	
		
		if(getFilled())
			g2d.fillOval(getPositionX(), getPositionY(), width, height);
		else
			g2d.drawRect(getPositionX(), getPositionY(), width, height);
		
	}
	
	public void centerUpdate(){
		centerX = getPositionX() + radius;
		centerY = getPositionY() + radius;
	}
	
	public int getCenterX() {
		return centerX;
	}
	
	public int getCenterY() {
		return centerY;
	}
	
	@Override
	public void setPositionX(int centerX) {
		super.setPositionX(centerX-radius);
	}
	
	@Override
	public void setPositionY(int centerY) {
		super.setPositionX(centerY-radius);
	}
	@Override
	public boolean intersect(Shape shape) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contain(Shape shape) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isMouseOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
