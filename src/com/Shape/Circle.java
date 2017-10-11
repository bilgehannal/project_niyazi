package com.Shape;

import java.awt.Graphics2D;


public class Circle extends Shape  {
	private int radius, width, height, centerX, centerY;
	
	
	
	public Circle( int centerX, int centerY, int radius) {
		super( centerX-radius, centerY-radius);
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
	public boolean crash(Shape shape) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contain(Shape shape) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
